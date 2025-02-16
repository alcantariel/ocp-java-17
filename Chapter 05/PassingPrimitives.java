public class PassingPrimitives {
  public static void main(String[] args) {
    int num = 4;
    newNumber(num);
    System.out.println(num); // 4
  }

  public static void newNumber(int num) {
    num = 8;
  }
}
