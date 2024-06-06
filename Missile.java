import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Missile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missile extends Actor
{
    /**
     * Act - do whatever the Missile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() + 9, getY());
        
        if (getX() == getWorld().getWidth()-1)
        {
          getWorld().removeObject(this);
        }
        
    }    
    
    public Missile(int x, int y)
    {
        setLocation(x,y);
    }  
}
