import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rec here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rec extends Actor
{
    /**
     * Act - do whatever the rec wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Records reco;
    public void act() 
    {
       if(Greenfoot.mouseClicked(this))
       {
           reco = new Records();
           Greenfoot.setWorld(reco);
       }
    }    
}
