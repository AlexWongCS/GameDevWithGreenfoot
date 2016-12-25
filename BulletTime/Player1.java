import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Player
{
    int idleFrame = 0;
    int walkFrame = 0;
    int jumpFrame = 0;
    int jumpDisplacement = -10;
    boolean onGround = true;
    boolean jumping = false;
    boolean falling = true;
    String status = "idle";
    String queueStatus = "idle";
    String facingDirection = "right";
    String currentSpriteFile = "p1idle1right.png";
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKey();
        resetAnimateFrame();
        checkJump();
        checkOnGround();
        animate();
    }

    public void checkKey()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            movement(-3,0);
            if(!jumping){
                queueStatus = "walk";
            }
            facingDirection = "left";
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            movement(3,0);
            if(!jumping){
                queueStatus = "walk";
            }
            facingDirection = "right";
        }
        else if(!jumping){
            queueStatus = "idle";
        }
        if(Greenfoot.isKeyDown("w") && status != "jump" && !falling){
            jumping = true;
            queueStatus = "jump";
        }

    }

    public void checkJump(){
        if(jumping){
            movement(0,jumpDisplacement);
            if(jumpDisplacement < 7){
                jumpDisplacement += 1;
            }
            if(jumpDisplacement < 0){
                falling = true;
            }

        }
        else if(!jumping && falling){
            movement(0, 6);
        }

    }

    public void movement(int x, int y)
    {
        this.setLocation(this.getX()+x,this.getY()+y);

    }

    public void resetAnimateFrame(){
        if(status != queueStatus){
            idleFrame = 0;
            walkFrame = 0;
            jumpFrame = 0;
            status = queueStatus;
        }
    }

    public void animate()
    {
        if(status == "idle")
        {
            animateIdle();
        }
        else if(status == "jump"){
            animateJump();
        }
        else if(status == "walk"){
            animateWalk();
        }

    }

    public void animateIdle()
    {
        boolean changeSprite = false;
        String fileName = "p1idle";
        if(idleFrame==0)
        {
            changeSprite = true;
            fileName += "1";
        }
        else if(idleFrame==30)
        {
            changeSprite = true;
            fileName += "2";
        }

        fileName += facingDirection;
        fileName += ".png";
        if(changeSprite){
            changeSprite(fileName);
        }
        idleFrame++;
        if(idleFrame > 60){
            idleFrame = 0;
        }
    }

    public void animateWalk(){
        boolean changeSprite = true;
        String fileName = "p1walk";
        if(walkFrame <= 8){
            fileName += "1";
        }
        else if(walkFrame <= 16){
            fileName += "2";
        }
        else if(walkFrame <= 24){
            fileName += "3";
        }
        else if(walkFrame <= 32){
            fileName += "4";
        }
        else if(walkFrame <= 40){
            fileName += "5";
        }
        else if(walkFrame <= 48){
            fileName += "6";
        }
        else if(walkFrame <= 56){
            fileName += "7";
        }
        else if(walkFrame <= 64){
            fileName += "8";
        }
        else if(walkFrame <= 72){
            fileName += "9";
        }
        else if(walkFrame <= 80){
            fileName += "10";
        }
        else if(walkFrame <= 88){
            fileName += "11";
        }
        else{
            changeSprite = false;
        }
        fileName += facingDirection;
        fileName += ".png";
        if(changeSprite){
            changeSprite(fileName);
        }
        walkFrame++;
        if(walkFrame > 88){
            walkFrame = 0;
        }

    }

    public void animateJump(){
        boolean changeSprite = true;
        String fileName = "p1jump";
        if(jumpFrame <= 5){
            fileName += "1";
        }
        else if(jumpFrame <= 10){
            fileName += "2";
        }
        else if(jumpFrame <= 15){
            fileName += "3";
        }
        else if(jumpFrame <= 20){
            fileName += "4";
        }
        else if(jumpFrame <= 25){
            fileName += "5";
        }
        else if(jumpFrame <= 30){
            fileName += "6";
        }
        else{
            changeSprite = false;
        }
        fileName += facingDirection;
        fileName += ".png";
        if(changeSprite){
            changeSprite(fileName);
        }

        jumpFrame++;

    }
    public void changeSprite(String fileName)
    {
        if(currentSpriteFile != fileName){
            currentSpriteFile = fileName;
            this.setImage(fileName);
        }

    }

    public void checkOnGround(){
        Actor obj1 = getOneObjectAtOffset(0, 20, Platform.class);
        Actor obj2 = getOneObjectAtOffset(0, 21, Bottom.class);
        if(obj1 != null || obj2 != null){
            jumpDisplacement = -12;
            jumping = false;
            falling = false;
            if(jumping){
                status = "idle";
            }
        }
        else if(!jumping && !falling && obj1 == null && obj2 == null){
            falling = true;
        }
        if(obj1 != null){
            this.setLocation(this.getX(), obj1.getY()-26);
        }
        else if(obj2 != null){
            this.setLocation(this.getX(), obj2.getY()-32);
        }
    }
}

