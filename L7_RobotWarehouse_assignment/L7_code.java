import java.util.ArrayList;

//Features left out
//-Check for "out-of-bounds"
//-Pathfinding if blocked


public class L7_code {
  public static void main(String[] args) {
    TestWareHouseArray myWarehouseRobots = new TestWareHouseArray(10,10);

    //Add robot 'A'
    myWarehouseRobots.addRobot(0,1,'A');
    myWarehouseRobots.wareHouseArray[0].setTarget(3,1);
    myWarehouseRobots.wareHouseArray[0].activateTarget();

    //Add robot 'B'
    myWarehouseRobots.addRobot(1,0,'B');
    myWarehouseRobots.wareHouseArray[1].setTarget(1,3);
    myWarehouseRobots.wareHouseArray[1].activateTarget();

    int step = 0;
    boolean success = false;
    System.out.println("Step: " + step);
    WarehouseRobot.printWareHouse(myWarehouseRobots.wareHouseArray);  //Print the warehouse grid
    while(!success){  //If not all robots have reached their target yet, keep going 
      success = true;
      for(WarehouseRobot currentBot: myWarehouseRobots.wareHouseArray){
        if(currentBot != null){  //Array is of fixed size. if() skips array elements without robots added to them
          currentBot.moveRobot();  //Let this bot perform one move
          success &= currentBot.isTargetReached();            //Has this bot reached their target?
        }
      }
      step++;
      System.out.println("Step: " + step);
      WarehouseRobot.printWareHouse(myWarehouseRobots.wareHouseArray);  //Update the warehouse grid
    }


    //Implemented having multiple robots as an ArrayList first.
    //Assignment was later extended to do this through the "TestWareHouseArray" instead, using an array instead of an ArrayList

    /*
    ArrayList<WarehouseRobot> myWarehouseRobots = new ArrayList<WarehouseRobot>();  //Skal implementeres som en klasse

    //Add robot 'A'
    myWarehouseRobots.add(new WarehouseRobot(0,1,'A'));
    myWarehouseRobots.get(0).setTarget(3,1);
    myWarehouseRobots.get(0).activateTarget();

    //Add robot 'B'
    myWarehouseRobots.add(new WarehouseRobot(1,0,'B'));
    myWarehouseRobots.get(1).setTarget(1,3);
    myWarehouseRobots.get(1).activateTarget();
    

    int step = 0;
    boolean success = false;
    System.out.println("Step: " + step);
    WarehouseRobot.printWareHouse(myWarehouseRobots);  //Print the warehouse grid
    while(!success){  //If not all robots have reached their target yet, keep going 
      success = true;
      for(WarehouseRobot currentBot: myWarehouseRobots){
        currentBot.moveRobot();  //Let this bot perform one move
        success &= currentBot.isTargetReached();            //Has this bot reached their target?
      }
      step++;
      System.out.println("Step: " + step);
      WarehouseRobot.printWareHouse(myWarehouseRobots);  //Update the warehouse grid
    }
    */
  }
}
