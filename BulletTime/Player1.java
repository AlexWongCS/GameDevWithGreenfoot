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
    float realJumpDisplacement = -10;
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
        MyWorld world = (MyWorld)getWorld();
        if(!world.paused){
            checkKey();
            resetAnimateFrame();
            checkJump();
            checkOnGround();
            animate();
            mapEdgeMove();
        }
    }

    public void mapEdgeMove(){
        if(this.getX()>=595 && facingDirection=="right"){
            this.setLocation(0,this.getY());
        }
        else if(this.getX()<=5 && facingDirection=="left"){
            this.setLocation(600,this.getY());
        }
    }

    public void checkKey()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            movement(-2,0);
            if(!jumping){
                queueStatus = "walk";
            }
            facingDirection = "left";
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            movement(2,0);
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
            if(realJumpDisplacement < 5){
                realJumpDisplacement+=0.5;
                jumpDisplacement = (int)realJumpDisplacement ;
            }
            if(realJumpDisplacement >= 0){
                falling = true;
            }

        }
        else if(!jumping && falling){
            movement(0, 4);
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
        else if(status == "jump" || falling){
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
        if(jumpFrame <= 2 && !falling){
            fileName += "1";
        }
        else if(jumpFrame<=4 && !falling){
            fileName += "2";
        }
        else if(jumpFrame <= 6 && !falling){
            fileName += "3";
        }
        else if(jumpFrame <= 13 && !falling){
            fileName += "4";
        }
        else if(jumpFrame <= 20 && !falling){
            fileName += "5";
        }
        else if(falling){
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
        boolean onLowest = this.getY()>=344;
        boolean onTop = false;
        if(obj1 != null){
            onTop = this.getY()<obj1.getY()-20;
        }
        if(obj1 != null && falling && onTop){
            this.setLocation(this.getX(), obj1.getY()-26);
        }
        else if(onLowest && falling){
            this.setLocation(this.getX(), 344);
        }
        if(((obj1 != null && onTop) || onLowest)&& falling){
            jumpDisplacement = -10;
            realJumpDisplacement = -10;
            jumping = false;
            falling = false;
            if(jumping){
                status = "idle";
            }
        }
        else if(!jumping && !falling && obj1 == null && !onLowest ){
            falling = true;
        }

    }
}

