import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    boolean init = true;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    public void act(){
        if(init){
            init = false;
            setPaintOrder(Player1.class);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setBackground(new GreenfootImage("bg2.png"));
        Player1 player1 = new Player1();
        addObject(player1,259,180);
        Platform platform = new Platform();
        addObject(platform,261,257);
        Platform platform2 = new Platform();
        addObject(platform2,326,328);
        platform2.setLocation(322,320);
        platform.setLocation(117,323);
        platform2.setLocation(280,328);
        Platform platform3 = new Platform();
        addObject(platform3,477,321);
        platform3.setLocation(453,313);
        Platform platform4 = new Platform();
        addObject(platform4,389,245);
        platform4.setLocation(385,241);
        Platform platform5 = new Platform();
        addObject(platform5,267,263);
        platform5.setLocation(253,273);
        Platform platform6 = new Platform();
        addObject(platform6,321,145);
        platform6.setLocation(303,201);
        Platform platform7 = new Platform();
        addObject(platform7,509,263);
        Platform platform8 = new Platform();
        addObject(platform8,565,339);
        platform8.setLocation(133,169);
        Platform platform9 = new Platform();
        addObject(platform9,233,101);
        Platform platform10 = new Platform();
        addObject(platform10,457,137);
        platform10.setLocation(441,153);
        platform10.setLocation(445,153);
        platform3.setLocation(467,313);
        platform7.setLocation(549,261);
        platform3.setLocation(465,315);
        Platform platform11 = new Platform();
        addObject(platform11,53,279);
        platform11.setLocation(47,273);
        Platform platform12 = new Platform();
        addObject(platform12,45,199);
        Platform platform13 = new Platform();
        addObject(platform13,553,195);
        platform7.setLocation(551,275);
        platform13.setLocation(551,205);
        platform8.setLocation(141,169);
        platform2.setLocation(294,328);
        platform5.setLocation(243,273);
        Orb orb = new Orb();
        addObject(orb,274,313);
        Orb orb2 = new Orb();
        addObject(orb2,412,335);
        Orb orb3 = new Orb();
        addObject(orb3,334,353);
    }
}
