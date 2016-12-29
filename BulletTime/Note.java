import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Note here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Note extends Actor
{
    public Note(){
        GreenfootImage img = new GreenfootImage("Note: Map edges are interconnected",20,Color.white,new Color(0,0,0,0));
        setImage(img);
    }
    /**
     * Act - do whatever the Note wants to do. This method is called whenever
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
