import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Virus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Virus extends Enemigo
{
    public static int radioFigura = 30;
    World m=getWorld();
    /**
     */
    public void act() 
    {
        super.move(-1);
        super.borraPowerUps();
        this.destruye();
    }
    
    public void destruye()
    {
        if(this.getX() < this.radioFigura)
        {
             this.getWorld().removeObject(this);
        }
    }
}
