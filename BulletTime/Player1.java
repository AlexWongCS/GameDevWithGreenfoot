import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Player
{
    boolean isIdle = true;
    int animateFrame = 0;
    String facingDirection = "right";
    String currentSpriteFile = "p1idle1right.png";
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animateIdle();
        frameLapse();
    }
    public void animate()
    {
        if(isIdle)
        {
            animateIdle();
        }
        
    }
    public void frameLapse()
    {
        animateFrame++;
        if(animateFrame>60)
        {
            animateFrame = 0;
        }
    }
    public void animateIdle()
    {
        boolean changeSprite = false;
        String fileName = "p1idle";
        if(animateFrame==0)
        {
            changeSprite = true;
            fileName += "1";
        }
        else if(animateFrame==30)
        {
            changeSprite = true;
            fileName += "2";
        }
        
        fileName += facingDirection;
        fileName += ".png";
        if((currentSpriteFile != fileName) && changeSprite)
        {
            currentSpriteFile = fileName;
            this.setImage(fileName);
        }
    }
}
