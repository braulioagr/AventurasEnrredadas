/**
 * Write a description of class Record here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Record  
{
    // instance variables - replace the example below with your own
    String nombre;
    int puntos;
    /**
     * Constructor for objects of class Record
     */
    public Record(String nombre, int puntos)
    {
        this.nombre = nombre;
        this.puntos = puntos;
    }
    @Override
    public String toString()
    {return nombre + "," + puntos;}
    public int dimePuntos()
    {
        return this.puntos;
    }
}
