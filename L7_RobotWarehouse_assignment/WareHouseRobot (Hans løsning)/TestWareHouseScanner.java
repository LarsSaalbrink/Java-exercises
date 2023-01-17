
/**
 * Write a description of class TestWareHouseArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class TestWareHouseScanner
{
    public static void main(String[] args)    
    {
        WareHouseRobot robot1 = new WareHouseRobot(0,0,123);
        robot1.setTarget(4,5);  
        robot1.activateTarget();

        WareHouseRobot robot2 = new WareHouseRobot(7,9,7);
        robot2.setTarget(0,0);
        robot2.activateTarget();

        WareHouseRobot robotWireless = new WareHouseRobot(0,5,42);
        robotWireless.setTarget(9,0);
        robotWireless.activateTarget();

        WareHouseRobot.printWareHouse();
        
        Scanner myObj = new Scanner(System.in);

        while(!robot1.targetReached() || !robot2.targetReached() || !robotWireless.targetReached() )
        {

            String inputString = myObj.nextLine();

            int moveInt = 0;
            if( inputString.charAt(0) == 'w'){
                moveInt = 4;
            }
            else if(inputString.charAt(0) == 's'){
                moveInt = 3;
            }
            else if(inputString.charAt(0) == 'a'){
                moveInt = 2;
            }
            else if(inputString.charAt(0) == 'd'){
                moveInt = 1;
            }

            robotWireless.moveRobot(moveInt);
            
            robot1.moveRobot();;

            robot2.moveRobot();

            WareHouseRobot.printWareHouse();
            
            
        }

        myObj.close();
    }
    
}
