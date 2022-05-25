import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Arrays;
/**
 * Write a description of class GameoverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends World
{
    public static int[] topScores = new int[5];
    Label restart = new Label("Press 'Enter' to retry",35);
    private int labelMoveDirection = -1;
    /**
     * Constructor for objects of class GameoverWorld.
     * 
     */
    public GameOverWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(restart,300,350);
        setHighScore(MyWorld.score);
        MyWorld.score = 0;
        GreenfootImage crocodile = new GreenfootImage("crocodile2.png");
        getBackground().drawImage(crocodile,25,175);
    }
    
    public void act(){
        moveLabelUp();
        moveLabelDown();
        if(Greenfoot.isKeyDown("enter")){
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
    
    public void setHighScore(int score){
        for(int i = topScores.length - 1; i > 0; i--){
            if(score > topScores[i]){
                topScores[0] = score;
                Arrays.sort(topScores);
                break;
            }
        }
        Integer[] topScoresWrapped = {topScores[0],topScores[1],topScores[2],topScores[3],topScores[4]};
        Label scoreboard = new Label("Top Scores \n"+topScoresWrapped[4].toString()+"\n"+topScoresWrapped[3].toString()+"\n"+topScoresWrapped[2].toString()+"\n"+topScoresWrapped[1].toString()+"\n"+topScoresWrapped[0].toString(),35);
        addObject(scoreboard, 300,125);
    }
    
    public void moveLabelDown(){
        if(restart.getY() < 350 && labelMoveDirection == 1){
            restart.setLocation(restart.getX(),restart.getY()+1);
        }else if(restart.getY() == 350){
            labelMoveDirection = -1;
        }
    }
    
    public void moveLabelUp(){
        if(restart.getY() > 340 && labelMoveDirection == -1){
            restart.setLocation(restart.getX(),restart.getY()-1);
        }else if(restart.getY() == 340){
            labelMoveDirection = 1;
        }
    }
}
