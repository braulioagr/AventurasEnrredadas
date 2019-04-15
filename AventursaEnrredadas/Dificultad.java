import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dificultad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dificultad extends World

{
    Facil fa;
    DifFacil f;
    DifDificil d;
    Regre re;
    /**
     * Constructor for objects of class Dificultad.
     * 
     */
    public Dificultad()
    {
        super(1000,667,1);
        f = new DifFacil();
        d = new DifDificil();
        re = new Regre();
        prepare();
    }
    
    private void prepare()
    {
        addObject(f,512,192);
        addObject(d,512,292);
        addObject(re,512,392);
    }
}
