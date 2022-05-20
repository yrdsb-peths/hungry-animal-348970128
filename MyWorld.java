import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static int score = 0;
    public Label scoreLabel = new Label(score,50);
    private int frames = 0;
    private int delay = 200;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(new Crocodile(), getWidth()/2, getHeight()/2);
        addObject(scoreLabel,70,70);
        score = 0;
    }

    public void act(){
        scoreLabel.setValue(score);
        if(frames%delay == 0){
            addObject(new Enemy(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        }
        if(frames%5 == 0 && delay >= 1){
            delay--;
        }
        frames++;
    }
}
