public class OrdOpdeler {
  String tekst;
  String skilleTegn;
  int indeks;

  OrdOpdeler(String kilde){  //Constructor
    tekst = kilde;
    skilleTegn = ", ";
    indeks = 0;
  }

  OrdOpdeler(String kilde, String skilleT){  //Constructor
    tekst = kilde;
    skilleTegn = skilleT;
    indeks = 0;
  }

  boolean erSkilleTegn(char tegn){
    for(int i = 0; i < skilleTegn.length(); i++){
      if(tegn == skilleTegn.charAt(i)){
        return true;
      }
    }
    return false;
  }

  boolean erDerFlereOrd(){
    for(int i = indeks; i < tekst.length(); i++){
      if(!(erSkilleTegn(tekst.charAt(i)))){
        return true;
      }
    }
    return false;
  }

  String naesteOrd(){
    String ordet = "";
    boolean ordStartet = false;
    while(indeks < tekst.length()){
      if(!(erSkilleTegn(tekst.charAt(indeks)))){     //Hvis validt bogstav
        ordet = ordet.concat(Character.toString(tekst.charAt(indeks)));
        ordStartet = true;
      }
      else if(ordStartet){  //Hvis ord er påbegyndt og skilletegn mødes
        return ordet;
      }
      indeks++;
    }
    //Hvis ingen valide bogstaver blev fundet og tekst er slut
    indeks = 0;  //Reset indeks så objektet kan bruges mere end en gang
    return ordet;  
  }

  String naesteOrd(String skilleT){
    skilleTegn = skilleT;

    return naesteOrd();
  }

  int antalOrd(){
    int antal = 0;
    int indeksHusker = indeks;  //Lagrer indekset så metoden ikke får det til at forsvinde
    indeks = 0;
    while(naesteOrd() != ""){
      antal++;
    }
    indeks = indeksHusker;  //Genindsætter indekset fra før metoden blev kaldt
    return antal;
  }

  int antalTegn(){
    return tekst.length();
  }

  int antalTegnUdenSkilleTegnOrd(){
    int antal = 0;
    for(int i = 0; i < tekst.length(); i++){
      if(!(erSkilleTegn(tekst.charAt(i)))){  //Hvis tegnet ikke er et skilletegn
        antal++;  //Tæl det
      }
    }
    return antal;
  }
}
