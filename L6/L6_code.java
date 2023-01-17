import java.util.ArrayList;

public class L6_code {
  public static void main(String[] args) {
    ArrayList<WarehouseRobot> myWarehouseRobots = new ArrayList<WarehouseRobot>();

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
    WarehouseRobot.printWarehouseGrid(myWarehouseRobots);  //Print the warehouse grid
    while(!success){  //If not all robots have reached their yet, keep going 
      success = true;
      for(WarehouseRobot currentBot: myWarehouseRobots){
        currentBot.moveRobot(currentBot.getNewPosition());  //Let this bot perform one move
        success &= currentBot.isTargetReached();            //Has this bot reached their target?
      }
      step++;
      System.out.println("Step: " + step);
      WarehouseRobot.printWarehouseGrid(myWarehouseRobots);  //Update the warehouse grid
    }
  }
}
