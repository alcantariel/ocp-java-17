public class VarargsWithOtherMethodParameters {
  public static void main(String[] args) {
    walkDog(1); // 0
    walkDog(1, 2); // 1
    walkDog(1, 2, 3); // 2
    walkDog(1, new int[] { 4, 5 }); // 2
  }

  public static void walkDog(int start, int... steps) {
    System.out.println(steps.length);
  }
}
