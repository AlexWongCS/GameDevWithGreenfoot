import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends Actor
{
    public Title(){
        GreenfootImage img = new GreenfootImage("BULLET TIME",48,Color.yellow,new Color(0,0,0,0));
        setImage(img);
    }
    /**
     * Act - do whatever the Title wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkSpace();
    }
    public void checkSpace(){
        if(Greenfoot.isKeyDown(" ")){
            getWorld().removeObject(this);
        }
    }
}
