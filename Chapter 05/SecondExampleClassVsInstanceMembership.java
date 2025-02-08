// Call `second()` as an instance method and not use static for the method or the variable

public class SecondExampleClassVsInstanceMembership {
  private static String name = "Sammy";

  public static void first() {
  }

  public void second() {
    System.out.println(name);
  }

  public static void main(String[] args) {
    var test = new SecondExampleClassVsInstanceMembership();
    test.second();
  }
}
