import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Juego here.
 * 
 * @author Braulio A. García Rivera 
 * @author Berrones Lopez Eduardo Miguel :3
 * @version (a version number or a date)
 */
abstract public class Juego extends World
{
    /**
     * Constructor for objects of class Juego.
     */
    protected int lim;
    protected int cor;
    protected int apa;
    protected SimpleTimer reloxPower;
    protected SimpleTimer reloj;
    protected SimpleTimer reloj2;
    public Juego(int x, int y, int c)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(x, y, c); 
        this.lim = y-33;
        reloxPower = new SimpleTimer();
        reloj = new SimpleTimer();
        reloj2 = new SimpleTimer();
        reloxPower.mark();
    }
    
    @Override
    abstract public void act();
    abstract public void aparecePowerUp();
    
    public void creaVirus()
    {
        cor = Greenfoot.getRandomNumber(lim);
        apa = Greenfoot.getRandomNumber(200);
        if (apa==1 || apa==3){
            if(cor<70)
            {
                cor +=70;
            }
            Virus virus = new Virus();
            addObject(virus,850,cor);
        }
        
    }
}
