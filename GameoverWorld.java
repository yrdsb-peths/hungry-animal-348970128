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
    public int[] topScores = new int[5];
    /**
     * Constructor for objects of class GameoverWorld.
     * 
     */
    public GameOverWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    public void setHighScore(int score){
        for(int i = topScores.length - 1; i > 0; i--){
            if(score > topScores[i]){
                topScores[topScores.length-1] = score;
                Arrays.sort(topScores);
                break;
            }
        }
    }
}
