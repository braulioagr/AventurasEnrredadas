import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Write a description of class Records here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Records extends World
{
    Regre reg;
    Counter[] records;
    /**
     * Constructor for objects of class Records.
     * 
     */
    public Records()
    {
        super(800,600,1);
        records = new Counter[5];
        reg = new Regre();
        prepare();
    }
    public void act()
    {
        
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        try{
            addObject(reg,650,526);
            Scanner archivo= new Scanner(new File("Reco.csv"));
            for(int i = 0; i < records.length; i++)
            {
                String linea = archivo.nextLine();
                String [] arreglo = linea.split(",");
                int puntos = Integer.parseInt(arreglo[1].trim());
                Counter  nuevo= new Counter(arreglo[0]+":");
                nuevo.setValue(puntos);
                addObject(nuevo,400,109*(i+1));
            }
        }
        catch(FileNotFoundException e){System.out.println("Falla");}
    }
}

