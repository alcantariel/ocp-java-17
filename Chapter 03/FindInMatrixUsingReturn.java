public class FindInMatrixUsingReturn {
  static final int SEARCH_VALUE = 2;

  public static void main(String[] args) {
    int[][] list = { { 1, 13 }, { 5, 2 }, { 2, 2 } };
    int[] results = searchForValue(list, SEARCH_VALUE);

    if (results == null) {
      System.out.println("Value " + SEARCH_VALUE + " not found");
    } else {
      System.out.println(String.format("Value %d found at: (%d, %d)", SEARCH_VALUE, results[0], results[1]));
    }
  }

  private static int[] searchForValue(int[][] list, int value) {
    for (int i = 0; i < list.length; i++) {
      for (int j = 0; j < list[i].length; j++) {
        if (list[i][j] == value) {
          return new int[] { i, j };
        }
      }
    }

    return null;
  }
}
