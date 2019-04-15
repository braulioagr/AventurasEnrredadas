import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ayu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ayu extends Actor
{
    Ayuda ayuda;
    /**
     * Act - do whatever the ayu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(Greenfoot.mouseClicked(this))
       {
           ayuda = new Ayuda();
           Greenfoot.setWorld(ayuda);
       }
    }    
}
