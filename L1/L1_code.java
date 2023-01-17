

public class L1_code {
  public static void main(String[] args) {
    /*
    int x = 5;
    System.out.println(x);
    x += 5;
    System.out.println(x);
    int y = 10;
    x *= y;
    System.out.println(x);
    System.out.println(x<y);
    System.out.println(x<y || x>y);
    System.out.println(x==y);
    System.out.println(++x);
    double xDouble = 2.5;
    System.out.println(xDouble);
    xDouble *= xDouble;
    System.out.println(xDouble);
    */

    /*
    Test testObj = new Test();
    testObj.setXY(5,6);
    System.out.println("Addition: " + testObj.sampleMethod());
    System.out.println("X greater than Y: " + testObj.xGreaterThanY());
    */

    Termostat klassevaerelse = new Termostat();
    System.out.println("For varmt: " + klassevaerelse.timeToCool(40.0));
    System.out.println("For koldt: " + klassevaerelse.timeToHeat(10.0));

    Termostat klassevaerelse2 = new Termostat();
    klassevaerelse.setTemperatures(45,5);
    System.out.println("For varmt: " + klassevaerelse.timeToCool(40.0));

    for(Termostat test = new Termostat(); test.timeToCool(40.0); test.setTemperatures((test.getTemperature()+1),5)){
      System.out.println("Yee");
    }

  }
}
