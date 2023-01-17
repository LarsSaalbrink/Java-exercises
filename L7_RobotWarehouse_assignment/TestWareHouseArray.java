public class TestWareHouseArray {
  public WarehouseRobot[] wareHouseArray;  //Not exactly good practice to use arrays here, ArrayLists make much more sense
  private int dims;
  private int index = 0;

  public TestWareHouseArray(int x, int y){
    dims = x*y;
    wareHouseArray = new WarehouseRobot[(dims)];  //Create an array of warehouse robots. Size is the max amount of robots that would fit on the warehouse grid
  }

  void addRobot(int xPos, int yPos, char id){
    wareHouseArray[index] = new WarehouseRobot(xPos,yPos,id);
    index++;
  }

  //As this does not interact with "index", only "dims" amount of robots can ever be added to a "TestWareHouseArray" object. (Removing does not make the element reuseable)
  void removeRobot(char id){
    for(WarehouseRobot i: wareHouseArray){
      if(i.id == id){
        i = null;
      }
    }
  }
}