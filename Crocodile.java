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
    private int shootDelayTracker = 0;
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
        movement();
        double rotation = (double)getRotation();
        if(Greenfoot.isKeyDown("space") && frames - shootDelayTracker >= 15){
            addProjectile(rotation);
            setImage(mouthAnimation[1]);
            shootDelayTracker = frames;
        }else if(frames - shootDelayTracker >= 5){
            setImage(mouthAnimation[0]);
        }
        frames++;
    }
    
    public void movement(){
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY()-2);
        }
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX()-2, getY());
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY()+2);
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX()+2, getY());
        }
    }
    
    public void addProjectile(double rotation){
        double radians = Math.toRadians(getRotation());
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        int dx = (int)Math.round(cos*101);
        int dy = (int)Math.round(sin*101);
        Projectile spit = new Projectile(rotation);
        getWorld().addObject(spit,getX()+dx,getY()+dy);
    }
}
