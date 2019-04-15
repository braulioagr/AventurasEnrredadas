import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * 
 */
public class Hacker extends Enemigo
{
    public static int radioFigura = 70;
    Random ran = new Random();
    @Override
    public  void act()
    {
       super.move(-2);
       super.borraPowerUps();
       this.destruye();
    }
    public void destruye()
    {
        if(this.getX() < this.radioFigura)
        {
             this.getWorld().removeObject(this);
        }
    }
    
}
