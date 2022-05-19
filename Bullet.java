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
    private int count = 0;
    
    public Bullet(double deg){
        GreenfootImage image = getImage();
        image.scale(50,50);
        setImage(image);
        this.deg = deg;
        turn((int)deg);
    }
    
    public void act()
    {
        double radians = Math.toRadians(getRotation());
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        int dx = (int)Math.round(cos *distance);
        int dy = (int)Math.round(sin *distance);
        setLocation(getX() +dx, getY() +dy);
        count++;
        if(count > 1000){
            getWorld().removeObject(this);
        }
    }
}
