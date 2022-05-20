import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public double deg;
    private int distance = 5;
    
    public Bullet(double deg){
        GreenfootImage image = getImage();
        image.scale(50,50);
        setImage(image);
        this.deg = deg;
        turn((int)deg+90);
    }
    
    public void act()
    {
        double radians = Math.toRadians(getRotation()-90);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        int dx = (int)Math.round(cos *distance);
        int dy = (int)Math.round(sin *distance);
        setLocation(getX() +dx, getY() +dy);
        while(getOneIntersectingObject(Enemy.class) != null){
            try {
                getWorld().removeObject(getOneIntersectingObject(Enemy.class));
                MyWorld.score++;
            }catch(Exception e){
                // This try/catch is only to prevent the bullet from trying to remove an already removed Enemy
            }
        }
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
