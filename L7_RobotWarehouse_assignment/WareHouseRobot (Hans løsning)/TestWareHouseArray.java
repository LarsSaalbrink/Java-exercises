
/**
 * Write a description of class TestWareHouseArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


public class TestWareHouseArray
{
    public static void main(String[] args)    
    {
        WareHouseRobot[] wareHouseRobotArray = new WareHouseRobot[10];
        for( int i = 0; i < 10; i++){
            wareHouseRobotArray[i] = new WareHouseRobot(0,i,9,i,i);
        }
        
        WareHouseRobot.printWareHouse();
        
        while(true)
        {
            boolean targetReachedAll = true;
            for( int i = 0; i < 10; i++){
                //int newPosition = wareHouseRobotArray[i].getNewPosition();
                //wareHouseRobotArray[i].moveRobot(newPosition);
                wareHouseRobotArray[i].moveRobot();
                targetReachedAll = targetReachedAll & wareHouseRobotArray[i].targetReached();
            }
            
            WareHouseRobot.printWareHouse();
            
            if( targetReachedAll )
                break;
            
        }
    }
    
}
