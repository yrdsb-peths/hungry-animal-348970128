import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public double rotation;
    private int distance = 5;
    private int touchedEnemies = 0;
    
    public Projectile(double deg){
        GreenfootImage image = getImage();
        setImage(image);
        rotation = deg;
        turn((int)rotation+90);
    }
    
    public void act()
    {
        double radians = Math.toRadians(getRotation()-90);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        int dx = (int)Math.round(cos * distance);
        int dy = (int)Math.round(sin * distance);
        setLocation(getX() + dx, getY() + dy);
        removeEnemy();
        if(isAtEdge() || touchedEnemies == 2){
            getWorld().removeObject(this);
        }
    }
    
    public void removeEnemy(){
        while(getOneIntersectingObject(Enemy.class) != null){
            try {
                getWorld().removeObject(getOneIntersectingObject(Enemy.class));
                touchedEnemies++;
                MyWorld.score++;
            }catch(Exception e){
                // This try/catch is only to prevent the projectile from trying to remove an
                // already removed Enemy, since enemy spawn speed can get really fast
            }
        }
    }
}
