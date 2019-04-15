import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 */
public class Bifurcacion extends Enemigo
{
    /**
     * Act - do whatever the Bifurcacion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int finfigura = 1;
    private SimpleTimer reloj;
    private int movimiento=-1;
    
    public Bifurcacion(){
        this.reloj= new SimpleTimer();
    }
    
    public Bifurcacion(int speed){
        this.reloj= new SimpleTimer();
        movimiento=speed;
    }
    
    @Override
    public void act() 
    {
        super.move(movimiento);
        super.borraPowerUps();
        if(this.isTouching(Enemigo.class)){
            if(this.isTouching(Hacker.class))
            {
                super.removeTouching(Hacker.class);
            }
            
            if(this.isTouching(Virus.class))
            {
                super.removeTouching(Virus.class);

            }
            
            if(this.isTouching(Bifurcacion.class))
            {
                //movimiento = 0;
            }
        }
        this.destruye();
    }
    
    public void destruye()
    {
        if(this.getX() < this.finfigura)
        {
            if (reloj.millisElapsed()>10000){
                this.getWorld().removeObject(this);
                reloj.mark();
                movimiento=-1;
           }
        }
    }
}
