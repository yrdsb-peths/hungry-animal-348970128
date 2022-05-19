import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Crocodile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crocodile extends Actor
{
    /**
     * Act - do whatever the Crocodile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int frames = 0;
    public void act()
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null){
            turnTowards(m.getX(),m.getY());
        }
        double rot = (double)getRotation();
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY()-3);
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+3);
        }
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-3, getY());
        }
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+3, getY());
        }
        if(Greenfoot.isKeyDown("space")){
            Bullet bullet = new Bullet(rot);
            getWorld().addObject(bullet,getX(),getY());
        }
        Integer rotation = getRotation();
        System.out.println(rotation.toString());
        frames++;
    }
}
