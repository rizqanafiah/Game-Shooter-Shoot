import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Missile2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missile2 extends Actor
{
    /**
     * Act - do whatever the Missile2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      setLocation(getX() - 10, getY());
        
        if (getX() <= 1)
        {
          getWorld().removeObject(this);
        }
        
    }    
    
    public Missile2(int x, int y)
    {
        setLocation(x,y);
    }   
}
