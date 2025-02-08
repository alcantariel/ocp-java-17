public class InvalidClassVsInstanceMembership {
  private String name = "Sammy";

  public static void first() {
  }

  public void second() {
    System.out.println(name);
  }

  public static void main(String[] args) {
    first();
    second();
  }
}
