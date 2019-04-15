import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Encriptacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Encriptacion extends PowerUps
{
    public static int radioFigura = 65;
    public void act() 
    {
        super.move(-1);
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
