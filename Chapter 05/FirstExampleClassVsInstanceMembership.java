// Add static to the name variable and method, for example

public class FirstExampleClassVsInstanceMembership {
  private static String name = "Sammy";

  public static void first() {
  }

  public static void second() {
    System.out.println(name);
  }

  public static void main(String[] args) {
    first();
    second();
  }
}
