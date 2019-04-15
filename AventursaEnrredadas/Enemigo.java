import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemigo extends Actor
{
    abstract public void act();
    abstract public void destruye();
    public void borraPowerUps()
    {
        if(this.isTouching(PowerUps.class))
        {
             super.removeTouching(PowerUps.class);
        }
    }
}
