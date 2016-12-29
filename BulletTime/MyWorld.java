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
    boolean paused = true;
    int score = 0;
    int plasmaCooldown = 150;
    int currentCooldown = 150;
    int orbCooldown = 100;
    int numOrbs = 0;
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
            setPaintOrder(Score.class);
        }
        if(!paused){
            orbCountdown();
            plasmaCountdown();
        }
    }

    public void orbCountdown(){
        orbCooldown--;
        if(orbCooldown<=0 && numOrbs<=5){
            orbCooldown = 100;
            addObject(new Orb(),Greenfoot.getRandomNumber(600),0);
            numOrbs++;
        }
    }

    public void plasmaCountdown(){
        currentCooldown--;
        if(currentCooldown<=0){
            currentCooldown = plasmaCooldown;
            addObject(new Plasma(),Greenfoot.getRandomNumber(600),0);
        }
    }

    public void increaseScore(){
        score++;
        if(plasmaCooldown>=30){
            plasmaCooldown-=8;
        }
    }

    public int getScore(){
        return score;
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
        platform9.setLocation(223,121);
        platform4.setLocation(421,239);
        platform8.setLocation(123,153);
        platform5.setLocation(233,255);
        platform6.setLocation(299,191);
        removeObject(orb3);
        removeObject(orb2);
        removeObject(orb);
        platform2.setLocation(306,318);
        platform.setLocation(127,319);
        platform3.setLocation(461,307);
        platform8.setLocation(129,155);
        platform8.setLocation(135,155);
        platform8.setLocation(135,159);
        platform10.setLocation(453,153);
        Score score = new Score();
        addObject(score,365,139);
        score.setLocation(29,383);
        score.setLocation(17,379);
        score.setLocation(59,381);
        score.setLocation(103,381);
        player1.setLocation(307,260);
        Platform platform14 = new Platform();
        addObject(platform14,129,226);
        Start start = new Start();
        addObject(start,310,313);
        start.setLocation(288,295);
        Controls controls = new Controls();
        addObject(controls,280,364);
        controls.setLocation(258,360);
        Note note = new Note();
        addObject(note,437,373);
        note.setLocation(457,379);
        Title title = new Title();
        addObject(title,295,172);
        title.setLocation(301,154);
    }
}
