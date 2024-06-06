import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sprite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sprite extends Actor
{
    public int gravity = 6;
    boolean right = true;
    public boolean jumping = false;
    public int shotDelay;
    public int jumpSpeed = 10;
    boolean atMax = false;
    boolean onGround = true;
    int animate = 0;
    boolean running = false;
    boolean doneAnimate = false;
    int currentFloor = 460;
    int platform = 0;
    
    Platform1 p1 = new Platform1();
    Platform2 p2 = new Platform2();
    
    /**
     * Act - do whatever the Sprite wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (jumping == false); {
            Gravity();
    }
        DetectFloor();
        move();
        shotDelay--;
    }  
       
    public void Gravity()
    {
       setLocation(getX(), getY() + gravity);
        
    }
    
    public void move()
    {
        
      if( Greenfoot.isKeyDown("right")) {
          
          setLocation(getX() + 3, getY());
          //running = true;
          right = true;
          //doneAnimate = false;
          
            /** while ( animate != 0 ) {
                animate += 3;
                if ( animate % 12 == 3 ) {
                    setImage("right-run1.png");
                }
                if ( animate % 12 == 6 ) {
                    setImage("right-run3.png");   
                }
                if ( animate % 12 == 9 ) {
                    setImage("right-run5.png");
                    animate = 0;
                }
            } */
                
        if ( right == true && jumping == true) {
            setImage("sprite-jumpright.png");
        }      
        
      } else {
            if ( right == true && running == false && jumping == false ) {
              setImage("sprite-normal.PNG");  
            }
        }
        
      if ( Greenfoot.isKeyDown("left")) {
          
          setLocation(getX() - 3, getY());
     
          if ( right == true){
            setImage("sprite-left.png");
          }
          right = false;
          
          if ( right == false && jumping == true ) {
             setImage("sprite-jumpleft.png"); 
            }
        
       }
      if ( Greenfoot.isKeyDown("up") && atMax == false ) {
          
        onGround = false;
        jumping = true;
        setLocation(getX(), getY() - jumpSpeed);
        
        if ( right == true && jumping == true) {
            setImage("sprite-jumpright.png");
        }
        
        if ( right == false && jumping == true) {
            setImage("sprite-jumpleft.png");
        }
       
        if (getY() <= (currentFloor - 150)) {
            jumping = false;
            atMax = true;
        }
        
        if (atMax == true) {
            jumping = false;
        }
        
                  
        } else {
            jumping = false;
        }
            
      if ( Greenfoot.isKeyDown("space") && shotDelay < 1) {
          fire();
        }
        
        
    }
    
    public void DetectFloor()
    {
            
       Actor hit = getOneIntersectingObject(Floor.class);
       if (hit instanceof Floor)
       {
           platform = 0;
           setLocation(getX(), 460);
           currentFloor = 460;
           atMax = false;
           jumping = false;
           onGround = true;
           
           if ( right == true ) {
               if ( running == false ) {
                setImage("sprite-normal.PNG"); }
            } else {
                if ( running == false ) {
                setImage("sprite-left.png"); }
            }
        }
        
           Actor hitPlatform1 = getOneIntersectingObject(Platform1.class);
            if ( hitPlatform1 instanceof Platform1 && jumping == false )
            {
                platform = 1;
                setLocation(getX(), 337);
                currentFloor = 337;
                atMax = false;
                jumping = false;
                onGround = true;
           
                if ( right == true ) {
                    if ( running == false ) {
                            setImage("sprite-normal.PNG"); }
            }   else {
                    if ( running == false ) {
                            setImage("sprite-left.png"); }
            }
            
            if ( jumping == false && atMax == true )
            {
                platform = 1;
                setLocation(getX(), 347);
                currentFloor = 347;
                atMax = false;
                jumping = false;
                onGround = true;
            }
        }
            
            Actor hitPlatform2 = getOneIntersectingObject(Platform2.class);
            if ( hitPlatform2 instanceof Platform2 && jumping == false && getY() <= 290 )
            {
                platform = 2;
                setLocation(getX(), 235);
                currentFloor = 235;
                atMax = false;
                jumping = false;
                onGround = true;
           
                if ( right == true ) {
                    if ( running == false ) {
                            setImage("sprite-normal.PNG"); }
            }   else {
                    if ( running == false ) {
                            setImage("sprite-left.png"); }
            }
            
            if ( jumping == false && atMax == true )
            {
                platform = 2;
                setLocation(getX(), 245);
                currentFloor = 245;
                atMax = false;
                jumping = false;
                onGround = true;
            }
        }
        
            
            
            /* 
             if ( getX() >= 750 && getY() >= 285 && getY() <= 290 ) {
                    setLocation(getX(), 291);
                } 
                //*/
            
          
    }


    
    public void fire()
    {
        Bullet shot = new Bullet(getX(), getY());
        Bullet2 leftShot = new Bullet2(getX(), getY());
        if ( right == true) {
            if ( onGround == true) {
            getWorld().addObject(shot, getX() + 49, getY() - 18); }
        } else {
            if ( onGround == true ) {
            getWorld().addObject(leftShot, getX() - 49, getY() - 18); }
        }
        shotDelay = 15;
    }
  
    
    
}

    

