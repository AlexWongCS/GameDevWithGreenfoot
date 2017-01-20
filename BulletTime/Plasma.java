import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
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
        checkDeletion();
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
    public void checkDeletion(){
        if(getY()>=390){
            getWorld().removeObject(this);
        }
        else{
            List l = getObjectsInRange(27,Player1.class);
            if(!l.isEmpty()){
                Greenfoot.setWorld(new MyWorld());
            }
        }
    }
}
