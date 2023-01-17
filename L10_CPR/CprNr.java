import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter; 

public class CprNr {
  private String nummeret;

  public CprNr(){}  //Constructor

  public CprNr(String etCprNr){  //Constructor
    nummeret = etCprNr;
  }

  public String getCprNr(){
    if(nummeret != null){
      return nummeret;
    }
    else{
      return "Ingen CPR nummer tildelt";
    }
  }

  public void setCprNr(String etCprNr){
    nummeret = etCprNr;
  }

  public int getDag(){
    return (Integer.parseInt(nummeret.substring(0,2)));
  }

  public int getMaaned(){
    return (Integer.parseInt(nummeret.substring(2,4))); 
  }

  public int getAar(){
    String mindstBetydende = nummeret.substring(4,6);

    //Fortolk betydning af 7. ciffer
    String mestBetydende = "99";
    switch((nummeret.charAt(6)-48)){  //-48 for at fjerne ASCII offset
      case 0: case 1: case 2: case 3:
        mestBetydende = "19";
        break;
      case 4: case 5:
        mestBetydende = "18";
        break;
      case 6: case 7: case 8: case 9:
        mestBetydende = "20";
        break;
    }
    return (Integer.parseInt(mestBetydende.concat(mindstBetydende)));
  }

  public Dato getDato(){
    Dato minDato = new Dato();
    minDato.setDag(this.getDag());
    minDato.setMaaned(this.getMaaned());
    minDato.setAar(this.getAar());

    return minDato;
  }

  public int getAlder(){
    //Find nuværende dato
    java.time.LocalDate nuværendeDatoHentet = java.time.LocalDate.now();
    Dato nuværendeDato = new Dato();
    nuværendeDato.setDag(nuværendeDatoHentet.getDayOfMonth());
    nuværendeDato.setMaaned(nuværendeDatoHentet.getMonthValue());
    nuværendeDato.setAar(nuværendeDatoHentet.getYear());

    Dato cprDato = getDato();
    //Tjek om person har haft fødselsdag i år
    if(cprDato.dagIAar() < nuværendeDato.dagIAar()){
      return (cprDato.forskelIDage(nuværendeDato) / 365);
    }
    else{
      return ((cprDato.forskelIDage(nuværendeDato) / 365)+1);
    }
    
  }

  public boolean erMand(){
    return (((Integer.parseInt(nummeret.substring(9))) % 2) == 1);
  }

  public boolean erKvinde(){
    return (((Integer.parseInt(nummeret.substring(9))) % 2) == 0);
  }
  
  public boolean erValid(){
    boolean valid = true;

    //"if()" struktureret for at minimere eksekveringstid
    if(nummeret.length() != 10){  //Tjek om der er præcis 10 karakterer
      valid = false;
      System.out.println("1");
    }
    else if(!(getDato().validDato())){  //Tjek om streng representerer en dato
      valid = false;
      System.out.println("2");
    }
    else {
      boolean mod11Tjek = 
        (((((nummeret.charAt(0)-48)*4) +
        ((nummeret.charAt(1)-48)*3) +
        ((nummeret.charAt(2)-48)*2) +
        ((nummeret.charAt(3)-48)*7) +
        ((nummeret.charAt(4)-48)*6) +
        ((nummeret.charAt(5)-48)*5) +
        ((nummeret.charAt(6)-48)*4) +
        ((nummeret.charAt(7)-48)*3) +
        ((nummeret.charAt(8)-48)*2) +
        ((nummeret.charAt(9)-48)*1))
        % 11) != 0);

      //Tjek om tallet passerer "modulus-11 check"
      if(mod11Tjek){
        valid = false;
        System.out.println("3");
      }
      else{  //Tjek om alle tegn er numeriske
        char[] valideChars = {'0','1','2','3','4','5','6','7','8','9'};
        boolean korrektCharFundet = false;
        for(int i = 0; i < 10; i++){
          for(char validChar: valideChars){
            if(nummeret.charAt(i) == valideChars[i]){
              korrektCharFundet = true;
            }
          }
        }
        if(!(korrektCharFundet)){
          valid = false;
          System.out.println("4");
        }
      }
    }
    return valid;
  }
}
