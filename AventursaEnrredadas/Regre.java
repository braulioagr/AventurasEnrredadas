import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Regre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Regre extends Actor
{
    /**
     * Act - do whatever the Regre wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Menu men;
    public void act() 
    {
       if(Greenfoot.mouseClicked(this))
       {
           men = new Menu();
           Greenfoot.setWorld(men);
       }
    }    
}
