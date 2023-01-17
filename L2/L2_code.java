

public class L2_code {
  public static void main(String[] args) {
    int x = 0;
    do{  //Once x = 3, print 3's forever
      System.out.println(x);
      if(x == 3){
        continue;
      }

      x++;
    }while (x <= 5);
  }
}
