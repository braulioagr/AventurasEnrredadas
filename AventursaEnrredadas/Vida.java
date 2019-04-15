import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida here
 */
public class Vida extends PowerUps
{
   public static int radioFigura = 65;
   public Vida ()
   {
        
   }
   
   @Override
   public void act()
   {
       super.move(-1);
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
