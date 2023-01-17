import java.util.*;
public abstract class Kunstvaerk
{
    String titel;
    int aar;
    Person[] ophavsmænd;
    int ophavsmændIndex = 0;
    
    public Kunstvaerk(){
      ophavsmænd = new Person[5];
    }

    public boolean addOphavsmand(Person ophavsmand){
      if(ophavsmændIndex < 5){
        ophavsmænd[ophavsmændIndex] = (Person) ophavsmand;  //Indsæt separat kopi af objektet "ophavsmand" i arrayet
        ophavsmændIndex++;
        return true;
      }
      else{
        System.out.println("Ikke flere ophavsmænd tilladt til dette kunstvaerk");
        return false;
      }
    }

    String getTitel(){
      return titel;
  }
}
