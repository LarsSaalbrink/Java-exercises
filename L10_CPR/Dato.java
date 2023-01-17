import java.lang.Math;     //For abs() methode

public class Dato
{
  private int enD;

  //Tilfoejede disse 3 for at spare en masse beregninger
  private int aar;
  private int maaned;
  private int dag;

  public Dato(int enD){
    this.enD = enD;

    if(!(validDato())){
      System.out.println("Brug format \"YYYYMMDD\"\n");
      throw new RuntimeException();
    }
    else{
      aar = enD / 10000;
      maaned = (enD /100) % 100;
      dag = enD % 100;
    }
  }

  public Dato(){
    
  }

  int getDatoen(){
    return enD;
  }

  int getAar(){  
    return aar;
  }

  int getMaaned(){  
    return maaned;
  }

  int getDag(){ 
    return dag;
  }

  int getKvartal(){ 
    int kvartal = 0;
    if(maaned < 4){
      kvartal = 1;
    }
    else if(maaned < 7){
      kvartal = 2;
    }
    else if(maaned < 10){
      kvartal = 3;
    }
    else{
      kvartal = 4;
    }
    return kvartal;
  }

  void setAar(int nytA){
    enD = (nytA * 10000) + (maaned * 100) + dag;
    aar = nytA;
  }

  void setMaaned(int nyM){
    enD = (aar * 10000) + (nyM * 100) + dag;
    maaned = nyM;
  }

  void setDag(int nyD){
    enD = (aar * 10000) + (maaned * 100) + nyD;
    dag = nyD;
  }

  boolean skudAar(){  //Skudaar hvis 4 gaar op i aarstallet, 100 goer ikke. Hvis 400 goer er det ok
    return ( ((aar % 4)==0) && (((aar % 100) != 0) || ((aar % 400) == 0)));
  }

  //Benytter hverken methoder eller de private variable af sikkerhedshensyn. 
  boolean validDato(){  
    boolean valid = true;
    if((0<(enD / 100000000)) || (0==(enD / 10000000)) || (0==(enD / 1000000)) || (0==(enD / 1000000)) ){  //Tjek om korrekt maengde inputcifre er givet
      valid = false;
      System.out.println("Forkert antal cifre");
    }
    else if(enD < 0){  //Tjek for negative tal
      valid = false;
      System.out.println("Negative datoer understoettes ikke");
    }
    else if(((enD /100) % 100) > 12){  //Tjek at maaned er realistisk
      valid = false;
      System.out.println("Kun 12 maander i et aar");
    }
    else{
      //Tjek at dag er realistisk
      int lDag = enD % 100;
      switch(((enD / 100) % 100)){
        case 1:case 3:case 5:case 7:case 8:case 10:case 12:
          if((lDag > 31)){
            valid = false;
            System.out.println("Denne maaned har maksimalt 31 dage");
          }
          break;
        case 4:case 6:case 9:case 11:
          if((lDag > 30)){
            valid = false;
            System.out.println("Denne maaned har maksimalt 30 dage");
          }
          break;
        case 2:
          int compDag = 28;
          int lAar = enD / 10000;
          if(((lAar % 4)==0) && (((lAar % 100) != 0) || ((lAar % 400) == 0))){  //if (skudAar())
            compDag += 1;
          }
          if((lDag > compDag)){
            valid = false;
            System.out.println("Forkert antal dage for denne februar");
          }
          break;
      }
    }
    return valid;
  }

  int dagIAar(){
    int dage = 0;
    dage += dag;

    for(int i=1; i < (maaned); i++){  //Itererer ikke over sidste maaned, gjort gennem overstaaende linje
      if(i == 2){
        dage += 28;
        if(skudAar()){
          dage += 1;
        }
      }
      else if ((((i % 2) == 1) && i < 8) || (((i % 2) == 0) && i >= 8)){  //Maaned 8 er august, som er 31 dage lang og efterfoelger en maaned paa 31 dage
        dage += 31;
      }
      else{
        dage += 30;
      }
    }
    return dage;
  }

  int restDageIAar(){
    int dagetotal = 365;
    if(skudAar()){
      dagetotal++;
    }
    return (dagetotal - dagIAar());
  }

  void setDatoPlusEn(){
    int sidsteDag = 99;

    switch(maaned){
      case 1:case 3:case 5:case 7:case 8:case 10:case 12:
        sidsteDag = 31;
        break;
      case 4:case 6:case 9:case 11:
        sidsteDag = 30;
        break;
      case 2:
        sidsteDag = 28;
        if(skudAar()){
          sidsteDag += 1;
        }
        break;
    }
    
    if(dag == sidsteDag){
      if(maaned == 12){
        setMaaned(1);
        setAar(aar+1);
      }
      else{
        setMaaned(maaned+1);
      }
      setDag(1);
    }
    else{
      setDag(dag+1);
    }
  }

  void setDatoMinusEn(){
    int dForrigMaaned = 99;

    switch(maaned){
      case 1:case 2:case 4:case 6:case 8:case 9:case 11:
        dForrigMaaned = 31;
        break;
      case 5:case 7:case 10:case 12:
        dForrigMaaned = 30;
        break;
      case 3:
        dForrigMaaned = 28;
        if(skudAar()){
          dForrigMaaned += 1;
        }
        break;
    }

    if(dag == 1){
      if(maaned == 1){
        setMaaned(12);
        setAar(aar-1);
      }
      else{
        setMaaned(maaned-1);
      }
      setDag(dForrigMaaned);
    }
    else{
      setDag(dag-1);
    }
  }

  void setNyDato(int antalD){
    for(int i = 0; i < Math.abs(antalD); i++){
      if(antalD < 0){
        setDatoMinusEn();
      }
      else{
        setDatoPlusEn();
      }
    }
  }

  int forskelIDage(Dato enD){
    int skuddage = 0;
    int slutAar,startAar;
    
    if(enD.aar > this.aar){  //For loop nedenfor taeller op, saa det skal sikres at taeller starter paa laveste aarstal
      slutAar = enD.aar; 
      startAar = this.aar; 
    }
    else{
      slutAar = this.aar;
      startAar = enD.aar;
    }
    
    //Find antallet af skudaar i den givne aarsraekke (Foerste og sidste aar undtaget, haandteres af dagIAar() )
    for(int i = startAar+1; i < slutAar; i++){
      if(( ((i % 4)==0) && (((i % 100) != 0) || ((i % 400) == 0)))){  //if(skudAar)
        skuddage++;
      }
    }

    int dageForskel = enD.dagIAar() - this.dagIAar();
    int aarDageForskel = ((enD.aar - this.aar) * 365);
    return Math.abs(aarDageForskel + dageForskel) + skuddage;
  }

  int ugeDag(){
    Dato kendtDato = new Dato(17000301);  //Dato givet som en mandag i opgaven

    //Hvis input dato ligger foer kendt dato
    if( (this.getAar() < kendtDato.getAar()) || 
        ((this.getAar() == kendtDato.getAar()) && (this.getMaaned() < kendtDato.getMaaned())) ||
        ((this.getAar() == kendtDato.getAar()) && (this.getMaaned() == kendtDato.getMaaned()) && (this.getDag() < kendtDato.getDag()))){  
      return (7-(((this.forskelIDage(kendtDato)) % 7)));  //Tael nedad
    }
    else{  //Ellers taelles der opad
      return ((this.forskelIDage(kendtDato)) % 7)+1; //+1 da opgavebeskrivelse ikke oensker nul-indekserede ugedage
    }
  }
}
