public class UsingMultidimensionalArray {
  public static void main(String[] args) {
    var twoD = new int[3][2];

    for (int i = 0; i < twoD.length; i++) {
      for (int j = 0; j < twoD[i].length; j++) {
        System.out.print(twoD[i][j] + " ");
      }

      System.out.println();
    }
  }
}
