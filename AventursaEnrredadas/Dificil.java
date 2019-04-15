import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dificil extends Juego
{
    private static final String bgImageName = "fondo.jpg";
    private static final double scrollSpeed =1;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;
    private SimpleTimer reloj1;
    private SimpleTimer reloj2;
    private Counter contBifu;
    private SimpleTimer relojmeta;
    private SimpleTimer relojbifu;
    private SimpleTimer relojcont;
    public boolean crea;
    public boolean activa;
    private static int ratioPower = 10;
    
    /**
     * Constructor for objects of class Dificil.
     * 
     */
    public Dificil()
    {
        super(800,600, 1);
        setPaintOrder(Correo.class,Meta.class,Bifurcacion.class,Counter.class,Hacker.class,Virus.class);
        Greenfoot.setSpeed(60);
        setBackground(bgImageName);
        bgImage = new GreenfootImage(getBackground());
        bgBase = new GreenfootImage(picWidth, getHeight());
        bgBase.drawImage(bgImage, 0, 0);
        Correo co = new Correo();
        addObject(co,76,300);
        this.reloj1= new SimpleTimer();
        this.reloj2= new SimpleTimer();
        this.relojbifu= new SimpleTimer();
        this.relojcont= new SimpleTimer();
        this.relojmeta= new SimpleTimer();
        this.contBifu =new Counter("Bifurcacion en: ");
        crea=false;
        activa=false;
        addObject(contBifu,75,587);
        Greenfoot.setSpeed(50);
    }
    
    @Override
    public void act()
    { 
        super.creaVirus();
        this.creaHacker();
        this.aparecePowerUp();
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
        if(reloj1.millisElapsed()> 18000){
            int contador = Greenfoot.getRandomNumber(10);
            if (contador == 1)
            {
                Greenfoot.setSpeed(60);
            }
        }
        if (reloj1.millisElapsed()>22000){
            Greenfoot.setSpeed(50);
            reloj1.mark();
        }
        
        if(reloj2.millisElapsed()>6000 && crea==false){
           int i = Greenfoot.getRandomNumber(2);
           if (i==1){
               creaBifurcacion();
           }
           reloj2.mark();
           relojcont.mark();
           relojbifu.mark();
        }
        
        if(relojcont.millisElapsed()>1000 && activa == true){
            contBifu.dec(1);
            relojcont.mark();
        }
        
        if(relojbifu.millisElapsed()>5000 && activa == true){
           contBifu.setLocation(75,587);
           nuevaBifurcacion();
           contBifu.setValue(0);
           relojbifu.mark();
           crea=false;
           activa=false;
           reloj2.mark();
        }
        
        if(relojmeta.millisElapsed()>120000){
            apareceMeta();
        }
    }
    
    public void creaBifurcacion(){
        contBifu.setValue(5);
        contBifu.setLocation(400,300);
        this.activa=true;
        this.crea=true;
    }
    
    public void nuevaBifurcacion(){
        Bifurcacion bif = new Bifurcacion();
        addObject(bif,400,300);
    }
    
    public void apareceMeta(){
        Meta meta = new Meta();
        addObject(meta,750,300);
    }
    
    @Override
    public void aparecePowerUp()
    {
      if(this.reloxPower.millisElapsed()>(ratioPower*1000))
       {
           int y;
           cor =Greenfoot.getRandomNumber(lim);
           if(cor<130)
           {
               cor +=130;
           }
           PowerUps vida = new Vida();
           addObject(vida,949,cor);
           this.reloxPower.mark();
       }
    }
    
    public void creaHacker()
    {
        cor = Greenfoot.getRandomNumber(lim);
        apa = Greenfoot.getRandomNumber(500);
        if (apa==1)
        {
            if(cor<130)
            {
                cor +=1300;
            }
            Hacker hacker = new Hacker();
            addObject(hacker,850,cor);
        }
    }
    
      private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
    }
}
