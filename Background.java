import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{
    public boolean right = true;
    
    /**
     * Constructor for objects of class Background.
     * 
     */
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        populate();
    }
    
    public void populate()
    {
       Floor floor = new Floor();
       addObject(floor, 450, 750);
       
       Platform1 platform1 = new Platform1();
       addObject(platform1, 725, 390);
       
       Platform2 platform2 = new Platform2();
       addObject(platform2, 250, 290);
       
       Turret turret1 = new Turret();
       addObject(turret1, 867, 325);
       
       Turret turret2 = new Turret();
       addObject(turret2, 33, 225);
       
       Sprite player = new Sprite();
       addObject(player, 100, 400);
    }
}
