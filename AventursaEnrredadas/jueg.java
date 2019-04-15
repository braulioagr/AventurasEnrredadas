import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class jueg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class jueg extends Actor
{
    /**
     * Act - do whatever the jueg wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Dificultad dif;
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
       {
           dif = new Dificultad();
           Greenfoot.setWorld(dif);
       }
    }    
}
