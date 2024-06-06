import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Turret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Turret extends Actor
{
    int animationTimer = 0;
    int attackTime = 1000;
    boolean right = false;
    
    /**
     * Act - do whatever the Turret wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animate();
        getRight();
    }  
    
    
    public void animate()
    {
       animationTimer++;
       
       if ( animationTimer % attackTime == 0 )
       {
          setImage("turret-Green.png"); 
        }
        
        if ( animationTimer % attackTime == (attackTime / 2))
        {
            setImage("turret-Red.png");
        }
        
        if ( animationTimer % attackTime == attackTime / 100 * 80 )
        {
            setImage("turret-Open1.png");
        }
        
        if ( animationTimer % attackTime == attackTime / 100 * 81 )
        {
            setImage("turret-Open2.png");  
        }
        
        if (animationTimer % attackTime == attackTime / 100 * 83 )
        {
            setImage("turret-Shooting.png");
            if ( right == true )
            {
                Missile2 missileLeft = new Missile2(getX(), getY());
                getWorld().addObject( missileLeft, getX(), getY());
            } else {
                Missile missileRight = new Missile(getX(), getY());
                getWorld().addObject( missileRight, getX(), getY());
            }
        }
        
        if (animationTimer % attackTime == attackTime / 100 * 98 )
        {
            setImage("turret-Closing1.png");
        }
       
        if (animationTimer % attackTime == attackTime / 100 * 99 )
        {
            setImage("turret-Closing2.png");
        }
    }
    
    public void getRight()
    {
            if ( getX() > getWorld().getWidth() / 2 ) {
                right = true;
            } else {
                right = false;
            }
            
    }
}
