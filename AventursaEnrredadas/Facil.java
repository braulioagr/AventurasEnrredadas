import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Facil here.
 * 
 * @author Braulio A. García Rivera 
 * @author Berrones Lopez Eduardo Miguel :3
 * 
 */
public class Facil extends Juego
{
    private static final String bgImageName = "fondo.jpg";
    private static final double scrollSpeed =1;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;
    //Timer de cambios de velocidad
    private SimpleTimer reloj1;
    private SimpleTimer relojmeta;
    Correo correo;
    /**
     * Constructor for objects of class Facil.
     * 
     */
    private static int ratioPower = 10;
    public Facil()
    {
        super(800,600, 1);
        Greenfoot.setSpeed(50);
        setPaintOrder(Correo.class,Meta.class,Virus.class,Counter.class);
        setBackground(bgImageName);
        bgImage = new GreenfootImage(getBackground());
        bgBase = new GreenfootImage(picWidth, getHeight());
        bgBase.drawImage(bgImage, 0, 0);
        this.reloj1= new SimpleTimer();
        this.relojmeta= new SimpleTimer();
        prepare();
    }

    @Override
    public void act()
    { 
        scrollPosition -= scrollSpeed;
        while(scrollSpeed > 0 && scrollPosition < -picWidth){
            scrollPosition += picWidth;
        }
        while(scrollSpeed < 0 && scrollPosition > 0){
            scrollPosition -= picWidth;
        }
        paint(scrollPosition);
        super.creaVirus();
        this.aparecePowerUp();
        /**
         *Con esto se setea de manera aleatoria la velocidad del juego en momentos dados conforme el tiempo 
         **/
        if(reloj1.millisElapsed()> 18000){
            int cont = Greenfoot.getRandomNumber(5);
            if (cont == 1)
            {
                Greenfoot.setSpeed(60);
            }
        }
        
        if (reloj1.millisElapsed()>22000){
            Greenfoot.setSpeed(50);
            reloj1.mark();
        }
        
        if(relojmeta.millisElapsed()>120000){
            apareceMeta();
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Correo correo = new Correo();
        addObject(correo,78,390);
    }
    
    @Override
    public void aparecePowerUp()
    {
      if(this.reloxPower.millisElapsed()>(ratioPower*1000))
       {
           int y;
           cor = Greenfoot.getRandomNumber(lim);
           apa = Greenfoot.getRandomNumber(2);
           PowerUps power;
           if(cor<130)
           {
               cor +=130;
           }
           
           if(apa == 1)
           {
               power = new Vida();
           }
           else
           {
               power = new Encriptacion();
           }
           
           addObject(power,949,cor);
           this.reloxPower.mark();
       }
    }
    
    public void apareceMeta(){
        Meta meta = new Meta();
        addObject(meta,750,300);
    }
    
     private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
    }
}
