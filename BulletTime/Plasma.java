import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plasma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plasma extends Actor
{
    int frame = 0;
    int speed = Greenfoot.getRandomNumber(2)+1;
    /**
     * Act - do whatever the Plasma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animate();
        fall();
        checkBottom();
    }

    public void animate(){
        if(frame==0){
            setImage("plasma1.png");
        }
        else if(frame==10){
            setImage("plasma2.png");
        }
        frame++;
        if(frame>=20){
            frame=0;
        }
    }

    public void fall(){
        setLocation(this.getX(),this.getY()+speed);
    }
    public void checkBottom(){
        if(getY()>=390){
            getWorld().removeObject(this);
        }
    }
}
