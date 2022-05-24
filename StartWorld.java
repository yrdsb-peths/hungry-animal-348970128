import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartWorld extends World
{
    Label start = new Label("Press 'space' to Start",35);
    private int labelMoveDirection = -1;
    /**
     * Constructor for objects of class StartWorld.
     * 
     */
    public StartWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Label title = new Label("Crocodile Madness",70);
        addObject(title,300,200);
        addObject(start,300,350);
    }
    
    public void act(){
        if(start.getY() > 340 && labelMoveDirection == -1){
            start.setLocation(start.getX(),start.getY()-1);
        }else if(start.getY() == 340){
            start.setLocation(start.getX(),start.getY()+1);
            labelMoveDirection = 1;
        }
        if(start.getY() < 350 && labelMoveDirection == 1){
            start.setLocation(start.getX(),start.getY()+1);
        }else if(start.getY() == 350){
            start.setLocation(start.getX(),start.getY()-1);
            labelMoveDirection = -1;
        }
        if(Greenfoot.isKeyDown("space")){
            Instructions world = new Instructions();
            Greenfoot.setWorld(world);
        }
    }
}
