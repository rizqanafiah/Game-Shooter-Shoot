import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet2 extends Actor
{
    boolean visible = true;
    /**
     * Act - do whatever the Bullet2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        DetectCollision();
        
        if ( visible == true )
        {
            DetectCollision();
            setLocation(getX() - 10, getY());
        
            if (getX() <= 1)
            {
                visible = false;
                getWorld().removeObject(this);
            }     
        } 
        
        
    }
    
    public Bullet2(int x, int y)
    {
        setLocation(x,y);
    }
    
    public void DetectCollision()
    {
       //*
         Actor collide1 = getOneIntersectingObject(Missile.class);
         Actor collide2 = getOneIntersectingObject(Missile2.class);
            if ( collide1 instanceof Missile )
            {
                visible = false;
                getWorld().removeObject(collide1);
                getWorld().removeObject(this);
            }
            if ( collide2 instanceof Missile2 )
            {
                visible = false;
                getWorld().removeObject(collide2);
                getWorld().removeObject(this);
            }
            //*/
    }
}

