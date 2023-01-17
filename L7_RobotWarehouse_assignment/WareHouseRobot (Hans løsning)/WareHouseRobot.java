/**
 * Write a description of class WareHouseRobot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class WareHouseRobot
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private int id;
    private int hastighed = 1;
    private int targetX;
    private int targetY;
    private boolean active = false;
    
    
    static boolean[][] wareHouseGrid = new boolean[10][10];
    
    static void printWareHouse()
    {
        for( int xi = 0; xi < 14; xi++){
            System.out.print("=");
        }
        System.out.println();  


        for( int yi = 0; yi < 10; yi++)
        {

            System.out.print("||");
            for( int xi = 0; xi < 10; xi++){
                if( wareHouseGrid[xi][yi] )
                    System.out.print("R");
                else
                    System.out.print(" ");
            }
            System.out.println("||");  
        }

    }
    
    /**
     * Constructor for objects of class WareHouseRobot
     */
    public WareHouseRobot(int x, int y, int id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
        wareHouseGrid[this.x][this.y] = true;
    }

    public WareHouseRobot(int x, int y, int targetX, int targetY, int id)
    {
        this.x = x;
        this.y = y;
        this.targetX = targetX;
        this.targetY = targetY;
        this.id = id;
        wareHouseGrid[this.x][this.y] = true;
    }
    
    public void setTarget(int x, int y) 
    {
        this.targetX = x;
        this.targetY = y;
    }
    
    public void activateTarget()
    {
        this.active = true;
    }

    public boolean targetReached()
    {
        if( this.targetX == this.x && this.targetY == this.y)
            return true;
        else
            return false;
    }    

    public int[] getTargetCoordinate()
    {
        int[] returnList = new int[2];
        returnList[0] = this.targetX;
        returnList[1] = this.targetY;
        return returnList;
    }
    
    public int[] getCurrentPosition()
    {
        int[] returnList = new int[2];
        returnList[0] = this.x;
        returnList[1] = this.y;
        return returnList;
    }
    
    public int getNewPosition()
    {
        if( this.targetX > this.x && wareHouseGrid[this.x+1][this.y] == false )
        {
            return 1;
        }
        if( this.targetX < this.x && wareHouseGrid[this.x-1][this.y] == false )
        {
            return 2;
        }       
        if( this.targetY > this.y && wareHouseGrid[this.x][this.y+1] == false )
        {
            return 3;
        } 
        if( this.targetY < this.y && wareHouseGrid[this.x][this.y-1] == false )
        {
            return 4;
        }
        return -1;
        
    }
    
    public void moveRobot(int direction)
    {
        if( !this.active)
            return;
        wareHouseGrid[this.x][this.y] = false;
        if( direction == 1 )
            this.x += 1;
        else if( direction == 2 )
            this.x -= 1;
        else if( direction == 3 )
            this.y += 1;
        else if( direction == 4 )
            this.y -= 1;    
        wareHouseGrid[this.x][this.y] = true;
    }
    
    void moveRobot()
    {
        if( !this.active)
            return;
        
        wareHouseGrid[this.x][this.y] = false;
        if( this.targetX > this.x && wareHouseGrid[this.x+1][this.y] == false )
        {
            this.x += 1;
        }
        else if( this.targetX < this.x && wareHouseGrid[this.x-1][this.y] == false )
        {
            this.x -= 1;
        }       
        else if( this.targetY > this.y && wareHouseGrid[this.x][this.y+1] == false )
        {
            this.y += 1;
        } 
        else if( this.targetY < this.y && wareHouseGrid[this.x][this.y-1] == false )
        {
            this.y -= 1;
        }
        wareHouseGrid[this.x][this.y] = true;
    }
    
    public static void main(String[] args)
    {
        WareHouseRobot.printWareHouse();
        
        WareHouseRobot myRobot = new WareHouseRobot(0,0,123);
        myRobot.setTarget(4,5);
        myRobot.activateTarget();

        WareHouseRobot secondRobot = new WareHouseRobot(7,9,7);
        secondRobot.setTarget(0,0);
        secondRobot.activateTarget();

        WareHouseRobot.printWareHouse();
        
        Scanner myObj = new Scanner(System.in);
        
        while(!myRobot.targetReached() || !secondRobot.targetReached())
        {
            int newPosition = myRobot.getNewPosition();
            myRobot.moveRobot(newPosition);
            //myRobot.moveRobot();
            
            newPosition = secondRobot.getNewPosition();
            secondRobot.moveRobot(newPosition);
            //secondRobot.moveRobot();
            
            
            int[] robotPositionXY = myRobot.getCurrentPosition();
            System.out.println("Robot1 Position: " + robotPositionXY[0] + " , " + robotPositionXY[1] );
            
            robotPositionXY = secondRobot.getCurrentPosition();
            System.out.println("Robot2 Position: " + robotPositionXY[0] + " , " + robotPositionXY[1] );
            
            WareHouseRobot.printWareHouse();
            
            String userName = myObj.nextLine();
            
            // Move the robot until the position is reached
        }
        myObj.close();
    }
}
