import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{
    private Label instructions = new Label("You are a crocodile tring to hit \n as many penguins with your vomit as possbile",30);
    private Label instructions2 = new Label("Press 'space' to shoot in the \n direction that the crocodile is facing",30);
    private Label instructions3 = new Label("The crocodile will always face the mouse, \n and there is a cooldown between each shot",30);
    private Label instructions4 = new Label("When there are more than 20 \n penguins in the world, you will lose",30);
    private Label continued = new Label("Press 'space' to continue",30);
    private int labelMoveDirection = -1;
    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(instructions,300,70);
        addObject(instructions2,300,140);
        addObject(instructions3,300,210);
        addObject(instructions4,300,280);
        addObject(continued,300,350);
    }
    
    public void act(){
        if(continued.getY() > 340 && labelMoveDirection == -1){
            continued.setLocation(continued.getX(),continued.getY()-1);
        }else if(continued.getY() == 340){
            continued.setLocation(continued.getX(),continued.getY()+1);
            labelMoveDirection = 1;
        }
        if(continued.getY() < 350 && labelMoveDirection == 1){
            continued.setLocation(continued.getX(),continued.getY()+1);
        }else if(continued.getY() == 350){
            continued.setLocation(continued.getX(),continued.getY()-1);
            labelMoveDirection = -1;
        }
        if(Greenfoot.isKeyDown("space")){
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
}
