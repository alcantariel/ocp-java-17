public class UsingBreakWithLabels {
  static final int SEARCH_VALUE = 2;

  public static void main(String[] args) {
    int[][] list = { { 1, 13 }, { 5, 12 }, { 2, 2 } };
    int positionX = -1;
    int positionY = -1;

    PARENT_LOOP: for (int i = 0; i < list.length; i++) {
      for (int j = 0; j < list[i].length; j++) {
        if (list[i][j] == SEARCH_VALUE) {
          positionX = i;
          positionY = j;
          break PARENT_LOOP;
        }
      }
    }

    if (positionX == -1 || positionY == -1) {
      System.out.println("Value " + SEARCH_VALUE + " not found");
    } else {
      System.out.println(String.format("Value %d found at: (%d, %d)", SEARCH_VALUE, positionX, positionY));
    }
  }
}
