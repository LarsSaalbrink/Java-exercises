import java.util.ArrayList;

public class WarehouseRobot {
  private char id;
  private int x;
  private int y;

  private int target_x;
  private int target_y;

  private int speed = 1;  //Grid squares the robot can move per cycle
  private boolean active = false;  //Is robot allowed to move when new cycle occurs

  static boolean[][] wareHouseGrid = new boolean[10][10];

  public WarehouseRobot(int x, int y, char id){
    this.x = x;
    this.y = y;
    this.id = id;
    wareHouseGrid[y][x] = true;  //Place the bot on the warehouse grid
  }

  /*
   * Set the target of the robot
   * 
   * @param x coordinate of target
   * @param y coordinate of target
   */
  void setTarget(int x, int y){
    target_x = x;
    target_y = y;
  }

  /*
   * Allow robot to move when moveRobot() is called
   */
  void activateTarget(){
    active = true;
  }

  /*
   * Disallow robot to move when moveRobot() is called
   */
  void deactivateTarget(){
    active = false;
  }

  /*
   * Allow robot to move when moveRobot() is called
   */
  boolean isTargetReached(){
    return (((x==target_x) ? true:false) && ((y==target_y) ? true:false));
  }

  /*
   * Get the target coordinates of the robot
   * 
   * @return int array containing x & y coordinates of the robots target
   */
  int[] getTargetCoordinate(){
    return new int[]{target_x,target_y};
  }

  /*
   * Get the coordinates of the robot
   * 
   * @return int array containing x & y coordinates of the robot
   */
  int[] getCurrentPosition(){
    return new int[]{x,y};
  }

  /*
   * Let the robot choose which direction it would like to move next.
   * Priorities movement along x-direction
   * 
   * @return Returns next direction to move in terms of clock direction
   *         Up = 12, Right = 3, Down = 6, Left = 9
   */
  int getNewPosition(){
    if(x < target_x){
      return 3;
    }
    else if(x > target_x){
      return 9;
    }
    else if(y < target_y){
      return 6;
    }
    else{
      return 12;
    }
  }

  /* 
   * Move "speed" steps in "dir" direction
   * 
   * @param dir direction to move in
  */
  void moveRobot(int dir){
    if(!isTargetReached() && active){
      wareHouseGrid[y][x] = false;

      //Carry out the movement
      switch (dir){
        case 3:
          if((target_x-x) < speed){
            x = (isPathClear(3))?target_x:x;  //x = target_x if target spot is not occupied by other robot
          }
          else{
            x += (isPathClear(3))?speed:0;  //x = x + speed if target spot is not occupied by other robot
          }
          break;
        case 9:
          if((x-target_x) < speed){
            x = (isPathClear(9))?target_x:x;  //x = target_x if target spot is not occupied by other robot
          }
          else{
            x -= (isPathClear(9))?speed:0;  //x = x - speed if target spot is not occupied by other robot
          }
          break;
        case 6:
          if((target_y-y) < speed){
            y = (isPathClear(6))?target_y:y;  //y = target_y if target spot is not occupied by other robot
          }
          else{
            y += (isPathClear(6))?speed:0;  //y = y + speed if target spot is not occupied by other robot
          }
          break;
        case 12:
          if((y-target_y) < speed){
            y = (isPathClear(12))?target_y:y;  //y = target_y if target spot is not occupied by other robot
          }
          else{
            y -= (isPathClear(12))?speed:0;  //y = y - speed if target spot is not occupied by other robot
          }
          break;
      }
      wareHouseGrid[y][x] = true;
    }
  }

  /*
   * Check if any other robot is blocking the path of this robot
   * Does not return accurate results if "speed" is greater than 1.
   * Method moveRobot() must be changed to moveRobots() to fix this issue
   * 
   * @param direction to check for obstacles
   * @return boolean indicating if path is clear of other robots
   */
  boolean isPathClear(int dir){
    boolean dirIsX = false;
    int incDir = 1;

    switch(dir){  //Set varibles to handle the axis and direction
      case 3:
        dirIsX = true;
        incDir = 1;
        break;
      case 9:
        dirIsX = true;
        incDir = -1;
        break;
      case 6:
        dirIsX = false;
        incDir = 1;
        break;
      case 12:
        dirIsX = false;
        incDir = -1;
        break;
    }

    //Check "speed" amount of cells ahead of the robot.  
    //If any are occupied, return false
    for(int i = 1; i <= speed; i++){  
      if(dirIsX){
        if(wareHouseGrid[y][x+(i*incDir)]){
          return false;
        }
      }
      else{
        if(wareHouseGrid[y+(i*incDir)][x]){
          return false;
        }
      }
      
    }
    return true;
  }

  /*
   * Find the robot in the ArrayList which has coordinates matching those provided as input arguments
   * 
   * @param x coordinate of robot you want "id" for
   * @param y coordinate of robot you want "id" for
   * @return char with id of the robot. If no robot matched the given coordinates, return 'Ø'
   */
  static char findRobotId(int x, int y, ArrayList<WarehouseRobot> myWarehouseRobots){
    for(WarehouseRobot robot:myWarehouseRobots){  //Loop through all robots
      if((robot.x == x) && (robot.y == y)){  //If this robot has the coordinates specified
        return robot.id;  //Return its id
      }
    }
    return 'Ø';  //Return 'Ø' if no robots have coordinates specified
  }

  /*
   * Print the full warehouse grid to the console.
   * Robots are marked with their id, empty cells are marked as dots
   * 
   * @param ArrayList of all the WarehouseRobot objects on the warehouse grid
   */
  static void printWarehouseGrid(ArrayList<WarehouseRobot> myWarehouseRobots){
    int x = 0;
    int y = 0;

    System.out.println("Warehouse grid: ");
    for(boolean[] xW: wareHouseGrid){
      for(boolean yW: xW){
        if(yW){  //If robot is present in this cell
          System.out.print(findRobotId(x,y,myWarehouseRobots)+" "); //Print the id of the robot
        }
        else{
          System.out.print(". ");  //Print a blank spot
        }
        x++;
      }
      System.out.println("");
      x=0;
      y++;
    }
  }
}
