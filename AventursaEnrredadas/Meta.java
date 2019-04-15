import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * hajkshjdsgfjkdsghajhfdk
 */
public class Meta extends Actor
{
    Menu me;
    
    public Meta(){
        me = new Menu();
    }
    /**
     * 
     */
    public void act() 
    {
        if(this.isTouching(Enemigo.class))
        {
            if(this.isTouching(Bifurcacion.class))
            {
                super.removeTouching(Bifurcacion.class);
            }
        }
        if(this.isTouching(Meta.class))
        {
                Greenfoot.delay(5);
                Greenfoot.setWorld(me);
        }
    }    
}
