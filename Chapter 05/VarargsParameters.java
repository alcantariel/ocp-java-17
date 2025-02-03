public class VarargsParameters {
  public static void main(String[] args) {
    // Pass an array
    int[] data = new int[] { 1, 2, 3 };
    walk(data); // 3

    // Pass a list of values
    walk(1, 2, 3); // 3

    // Omit values
    walk(); // 0
  }

  public static void walk(int... steps) {
    System.out.println(steps.length);
  }
}
