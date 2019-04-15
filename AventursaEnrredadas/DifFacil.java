import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DifFacil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DifFacil extends Actor
{
    Facil diffa;
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
       {
           diffa = new Facil();
           Greenfoot.setWorld(diffa);
       }
    }  
}
