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
    private GreenfootImage[] mouthAnimation = new GreenfootImage[2];
    
    public Crocodile(){
        super();
        for(int i = 0; i < 2; i++){
            mouthAnimation[i] = new GreenfootImage("crocodile" + (i+1) + ".png");
        }
    }
    
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
            double radians = Math.toRadians(getRotation());
            double sin = Math.sin(radians);
            double cos = Math.cos(radians);
            int dx = (int)Math.round(cos*101);
            int dy = (int)Math.round(sin*101);
            Bullet bullet = new Bullet(rot);
            getWorld().addObject(bullet,getX()+dx,getY()+dy);
            setImage(mouthAnimation[1]);
        }else{
            setImage(mouthAnimation[0]);
        }
        frames++;
    }
}
