public class Test{
  private int x;
  private int y;

  public Test(){
    this.x = 0;
    this.y = 0;
  }

  public void setXY(int x, int y){
    this.x = x;
    this.y = y;
  }

  public boolean xGreaterThanY(){
    return this.x > this.y;
  }

  public int sampleMethod(){
    return this.x + this.y;
  }
}