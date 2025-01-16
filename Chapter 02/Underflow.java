public class Underflow {
  public static void main(String[] args) {
    System.out.println(Integer.MIN_VALUE); // -2147483648
    System.out.println(Integer.MIN_VALUE - 1); // 2147483647
    System.out.println(Integer.MIN_VALUE - 2); // 2147483646
  }
}
