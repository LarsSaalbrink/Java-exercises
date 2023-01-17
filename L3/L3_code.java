import java.util.Arrays;

public class L3_code
{
  public L3_code()
  {
  }

  public void printStringArray()
  {
    String[] myStrings = new String[6];

    myStrings[0] = "this";
    myStrings[1] = "is";
    myStrings[2] = "Andy";
    myStrings[3] = "Warhol";
    myStrings[4] = "take";
    myStrings[5] = "one";

  for (int i = 0; i < myStrings.length; i++)
    System.out.println(myStrings[i]);
  }

  public static void printIntegerArray(int[] myInts)
  {
    for (int i = 0; i < myInts.length; i++)
      System.out.println(myInts[i]);
  }

  public int sumOfArray(int[] myInts)
  {
    // returnerer summen af elementerne i arrayet
    int sum = 0;
    for(int i: myInts){
      sum += i;
    }
    return sum;
  }

  public int averageOfArray(int[] myInts)
  {
    // returnerer gennemsnitsværdien (udregnet ved heltalsdivision)
    return (sumOfArray(myInts) / myInts.length);
  }

  public static int[] sortArray(int[] myInts)
  {
    // sorterer arrayet og skriver det ud
    Arrays.sort(myInts);
    return myInts;
  }

  public int maxOfArray(int[] myInts)
  {
    // returnerer den største værdi i arrayet
    Arrays.sort(myInts);
    return myInts[(myInts.length-1)];
  }

  public int minOfArray(int[] myInts)
  {
    // returnerer den største værdi i arrayet
    Arrays.sort(myInts);
    return myInts[0];
  }

  public static int[][] addMatrices(int[][] a, int[][] b)
  {
    // adder to matricer af samme størrelse og udskriv resultatet
    // tjek efterfølgende metode printMatrix for inspiration
    int[][] c = {
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0}
    };
    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a[0].length; j++){
        c[i][j] = a[i][j] + b[i][j];
      }
    }
    return c;
  }

  public static void printMatrix(int[][] m)
  {
    System.out.println("");
    for (int i = 0; i < m.length; i++){
      for (int j = 0; j < m[0].length; j++)
        System.out. print(m[i][j] + " ");
        System.out.println("");
      }
    System.out.println("\nLength "+m.length+" Width "+m[0].length);
  }

  public static void main(String[] args)
  {
    int[] myInts = {17,12,89,2,43,67,11};

    L3_code o = new L3_code();

    System.out.println("Sum: " + o.sumOfArray(myInts));  //Print summen af tallene

    System.out.println("Average: " + o.averageOfArray(myInts));  //Print gennemsnittet af tallene

    System.out.println("All numbers: ");
    printIntegerArray(myInts);  //Print tallene hver for sig

    System.out.println("All numbers sorted: ");
    printIntegerArray(sortArray(myInts));

    System.out.println("Max Number: " + o.maxOfArray(myInts));
    System.out.println("Min Number: " + o.minOfArray(myInts));

    int[][] filter = {
      {-1, 0, 7, 4},
      {-2, 1, 8, 5},
      {-3, 2, 9, 6}
    };
    printMatrix(filter);

    printMatrix(addMatrices(filter,filter));
    }

}
