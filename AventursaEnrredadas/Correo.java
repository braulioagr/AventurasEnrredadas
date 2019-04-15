import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Write a description of class Correo here.
 * 
 * @author Braulio A. García Rivera 
 * @author Berrones Lopez Eduardo Miguel :3
 * @version 28/10/17
 */
public class Correo extends Actor
{
    public  int movimiento = 5;
    private boolean encript;
    private Counter vidas;
    private Counter topeVidas;
    private Counter puntos;
    private SimpleTimer tiempoEncript;
    private SimpleTimer reloj;
    private String nombre = "";
    World m=getWorld();
    Record[] records;
    public Correo()
    {
        try{
            records = new Record[5];
            nombre = Greenfoot.ask("Como te llamas:");
            this.vidas = new Counter("Vidas: ");
            this.topeVidas = new Counter("Contenedores: ");
            this.puntos = new Counter("Puntos:    ");
            this.tiempoEncript = new SimpleTimer();
            this.reloj= new SimpleTimer();
            this.encript = false;
            Scanner archivo= new Scanner(new File("Reco.csv"));
            for(int i = 0; i < records.length; i++)
            {
                String linea = archivo.nextLine();
                String [] arreglo = linea.split(",");
                int puntos = Integer.parseInt(arreglo[1].trim());
                Record  nuevo= new Record(arreglo[0],puntos);
                records[i] = nuevo;
            }
        }
        catch(FileNotFoundException e){System.out.println("Falla");}
    }
    
     @Override()
    protected void addedToWorld(World world)
    {
        world.addObject(topeVidas,182,13);
        topeVidas.setValue(10);
        world.addObject(vidas,44,13);
        vidas.setValue(3);
        world.addObject(puntos, 340,13);
        this.puntos.setValue(400);
        reloj.mark();
    }
    
    /**
     * Metodo act() heredado de la clase actor sobre escrito este realiza una serie de validaciones
     * la cual permite realizar
     */
    @Override
    public void act() 
    {
        //iniciaVidas();
        try{
            mover();
            this.obtenPowerUp();
            this.recibeDanio();
            this.desactivaEncrip();
            this.decrementa();
            this.muerte();
            if(this.isTouching(Meta.class))
            {
                this.record();
                Greenfoot.delay(50);
            }
            
        }
        catch (IOException e) {System.out.print("Falla 2");}
        
    } 
    
    /**
     * Este metodo permite mover, al jugador
     */
    public void mover() 
    {
        
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+movimiento);
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-movimiento);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+movimiento,getY());
        }
        if(Greenfoot.isKeyDown("left"))
        {
           setLocation(getX()-movimiento,getY());
        }
       
    }
    
    /**
     * Este metodo reproduce el sonido que indica que se obtubo un powerUp
     * y ademas checa cual de los powerUps que 
     */
    public void obtenPowerUp()
    {
        if(this.isTouching(PowerUps.class))
        {
             this.puntos.add(10);
             if(this.isTouching(Encriptacion.class))
             {
                 Greenfoot.playSound("PowerUp.wav");
                 this.encript = true;
                 this.tiempoEncript.mark();
                 this.setImage("iitmail1.png");
                 super.removeTouching(Encriptacion.class);
                }
                else
                {
                    Greenfoot.playSound("Vida.wav");
                    super.removeTouching(Vida.class);
                    if(this.vidas.getValue() != this.topeVidas.getValue())
                    {
                        this.vidas.setValue(this.vidas.getValue()+1);
                    }
                }
        }
        
    }
    
    /**
     * El metodo recibe daño primero verifica que tipo enemigo es y lo remueve del mundo, despues verifica
     *      si la encritacion no esta activada.
     *      Si no lo esta hara e daño correspondiente
     */
    public void recibeDanio()
    {
        if(this.isTouching(Enemigo.class))
        {
            if(this.isTouching(Hacker.class))
            {
                super.removeTouching(Hacker.class);
                if(!encript)
                {
                    this.topeVidas.setValue(this.topeVidas.getValue()-1);
                }
                if(encript){
                    this.puntos.add(5);
                }
            }
            
            if(this.isTouching(Virus.class))
            {
                super.removeTouching(Virus.class);
                if(!encript)
                {
                    this.vidas.setValue(this.vidas.getValue()-1);
                    this.puntos.setValue(this.puntos.getValue()-10);
                }
                 if(encript){
                    this.puntos.add(2);
                }
            }
            
            if(this.isTouching(Bifurcacion.class))
            {
                this.vidas.setValue(this.vidas.getValue()-1);
                this.puntos.setValue(this.puntos.getValue()-20);
                setLocation(20,80);
            }
        }
    }
   
    public void desactivaEncrip()
    {
        if(tiempoEncript.millisElapsed() > 6000 && this.encript)
        {
            this.encript =  false;
            this.setImage("EmailPersonaje.png");
        }
    }
    
    public void muerte()
    {
        if(this.vidas.getValue() == 0 || puntos.getValue() == 0)
        {
            Greenfoot.stop();
        }
    }
    
    public void decrementa()
    {
        if(reloj.millisElapsed()> 1000)
        {
            this.puntos.setValue(this.puntos.getValue()-1);
            this.reloj.mark();
        }
    }
    
    public void seteaMovimiento(int velmov){
        this.movimiento = velmov;
    }
    
    public void record() throws IOException
    {
        if(this.records[4].dimePuntos() < puntos.getValue())
        {
            Record  nuevo = new Record(this.nombre,puntos.getValue());
            records[records.length-1] = nuevo;
            //Algoritmo de Ordenacion
            for(int i = 0; i < records.length; i++)
            {
            	for(int j=i+1;j<records.length;j++)
            	{
            		if(records[i].dimePuntos()<records[j].dimePuntos())
            		{
            			Record variableauxiliar=records[i];
            			records[i]=records[j];
            			records[j]=variableauxiliar;
            		}
            	}
            }
            //Grabado de Archivo
            FileWriter archivo = new FileWriter("Reco.csv");
            for(int i = 0; i < records.length; i++)
            {
                archivo.write(records[i].toString());
                archivo.write("\n");
            }
            archivo.close();
        }
    }
}
