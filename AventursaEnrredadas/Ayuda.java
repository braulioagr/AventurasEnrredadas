import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ayuda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ayuda extends World
{
    Regre reg;
    /**
     * Constructor for objects of class Ayuda.
     * 
     */
    public Ayuda()
    {
        super(1000,640,1);
        reg = new Regre();
        reg.setImage("regresar(2).png");
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(reg,700,540);
    }
}
