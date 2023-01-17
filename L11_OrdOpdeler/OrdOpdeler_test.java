public class OrdOpdeler_test {
  public static void main(String[] args) {
    OrdOpdeler testObj = new OrdOpdeler("Gid du var i Skanderborg og blev der, kære Peter.");

    System.out.println("Er \"a\" er skilletegn? " + testObj.erSkilleTegn('a'));
    System.out.println("Er \",\" er skilletegn? " + testObj.erSkilleTegn(',') + "\n");

    String naeste;
    do{
      naeste = testObj.naesteOrd(". ,");
      System.out.println(naeste);
    }while(naeste != "");

    System.out.println("Antal ord: " + testObj.antalOrd());
    System.out.println("Antal tegn: " + testObj.antalTegn());
    System.out.println("Antal tegn i ord: " + testObj.antalTegnUdenSkilleTegnOrd());
  }
}
