import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Orb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orb extends Actor
{
    boolean onSomething = false;
    int speed = Greenfoot.getRandomNumber(2)+1;
    /**
     * Act - do whatever the Orb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!onSomething){
            fall();
        }
        checkTouched();
    }

    public void fall(){
        Actor obj1 = getOneObjectAtOffset(0,10,Platform.class);
        if(obj1 != null){
            onSomething = true;
            this.setLocation(this.getX(),obj1.getY()-18);
        }
        else if(this.getY()>=352){
            onSomething = true;
            this.setLocation(this.getX(),352);
        }
        else{
            this.setLocation(this.getX(),this.getY()+speed);
        }
    }

    public void checkTouched(){
        List l = getObjectsInRange(27,Player1.class);
        if(!l.isEmpty()){
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            world.numOrbs--;
            getWorld().removeObject(this);
        }
    }
}
