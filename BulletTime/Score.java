import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    public Score(){
        GreenfootImage img = new GreenfootImage("Score: 0",36,Color.white,new Color(0,0,0,0));
        setImage(img);
    }
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateScore();
    }
    public void updateScore(){
        MyWorld world = (MyWorld)getWorld();
        int score = world.getScore();
        String strScore = String.valueOf(score);
        String finalString = "Score: " + strScore;
        GreenfootImage img = new GreenfootImage(finalString,36,Color.white,new Color(0,0,0,0));
        setImage(img);
    }
}
