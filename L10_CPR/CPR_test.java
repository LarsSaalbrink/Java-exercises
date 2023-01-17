public class CPR_test {
  public static void main(String[] args) {
    CprNr farmorsCpr = new CprNr("0502201972");

    System.out.println("Fuld CPR: " + farmorsCpr.getCprNr());

    System.out.println("Dag: " + farmorsCpr.getDag());
    System.out.println("Måned: " + farmorsCpr.getMaaned());
    System.out.println("År: " + farmorsCpr.getAar());

    Dato farmorsDato = farmorsCpr.getDato();
    System.out.println("Fuld dato: " + farmorsDato.getDatoen());
    System.out.println("Alder: " + farmorsCpr.getAlder());

    System.out.println("Er mand: " + farmorsCpr.erMand());
    System.out.println("Er kvinde: " + farmorsCpr.erKvinde());

    System.out.println("Validt CPR nr: " + farmorsCpr.erValid());
  }
}
