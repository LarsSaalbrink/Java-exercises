import java.util.Scanner;  //Bruger input

public class L4_dates_assignment
{
  //Main() med testkode
  public static void main(String[] args)
  {
    //Hardcoded data input
    //Dato givenDato = new Dato(17000229);

    //Manuelt dato input
    Scanner myScanner = new Scanner(System.in);
    boolean ex1 = true;
    boolean ex2 = true;
    int datoInput = 0;
    Dato givenDato = null;  //Erklaeres her for at sikre at den er i scope, paa trods af at der ikke er en vaerdi til den endnu

    do{  //Tjek om format af korrekte symboler understoettes
      try{
        do{  //Tjek om bruger indtaster korrekte symboler
          try{
            System.out.println("Indsaet en dato i format: \"YYYYMMDD\"\n");
            datoInput = myScanner.nextInt();
            ex1 = false;
          }
          catch(Exception e){
            System.out.println("Forkert input, proev igen.\n");
            myScanner.nextLine();  //Fjern det forkerte input fra myScanners buffer
          }
        }
        while(ex1);

        givenDato = new Dato( datoInput );
        ex2 = false;
      }
      catch(Exception e){
        //Feedback om fejl allerede printet paa dette tidspunkt
      }
    } while(ex2);

    givenDato.setAar(givenDato.getAar());
    givenDato.setMaaned(givenDato.getMaaned());
    givenDato.setDag(givenDato.getDag());

    givenDato.setDatoPlusEn();
    givenDato.setDatoMinusEn();
    givenDato.setNyDato(17);
    givenDato.setNyDato(-17);

    System.out.println("\n---Given Dato---");
    System.out.println("Dato: " + givenDato.getDatoen());
    System.out.println("Aar: " + givenDato.getAar());
    System.out.println("Maaned: " + givenDato.getMaaned());
    System.out.println("Dag: " + givenDato.getDag());
    System.out.println("Kvartal: " + givenDato.getKvartal());
    System.out.println("Dage i aar: " + givenDato.dagIAar());
    System.out.println("Skudaar: " + givenDato.skudAar());
    System.out.println("dagIAar: " + givenDato.dagIAar());
    System.out.println("restDageIAar: " + givenDato.restDageIAar());
    
    Dato ForskelDato = new Dato(20000123);
    System.out.println("Forskel fra dato \"20000123\": "+givenDato.forskelIDage(ForskelDato));

    String[] ugedage = {"Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "Loerdag", "Soendag"};
    System.out.println("Ugedag: " + givenDato.ugeDag() + " - " + ugedage[givenDato.ugeDag()-1]);
  }
}
