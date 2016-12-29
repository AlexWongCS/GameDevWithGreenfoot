import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Actor
{
    public Start(){
        GreenfootImage img = new GreenfootImage("Press Space to Start",36,Color.white,new Color(0,0,0,0));
        setImage(img);
    }
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       checkSpace();
    }    
    public void checkSpace(){
        if(Greenfoot.isKeyDown(" ")){
            MyWorld world = (MyWorld)getWorld();
            world.paused = false;
            getWorld().removeObject(this);
        }
    }
}
