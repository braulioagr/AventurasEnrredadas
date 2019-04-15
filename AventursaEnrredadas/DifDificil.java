import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DifDificil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DifDificil extends Actor

{
    Dificil difdif;
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
       {
           difdif = new Dificil();
           Greenfoot.setWorld(difdif);
       }
    }  
}
