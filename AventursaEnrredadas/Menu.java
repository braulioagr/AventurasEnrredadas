import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World 
{
    ayu a;
    rec r;
    jueg ju;
    salir sa;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {
        super(800,600,1);
        a = new ayu();
        r = new rec();
        ju = new jueg();
        sa = new salir();
        prepare();
    }


    @Override
    public void act()
    {
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(ju,400,192);
        addObject(r,400,292);
        addObject(a,400,392);
        addObject(sa,400,492);
    }
}
