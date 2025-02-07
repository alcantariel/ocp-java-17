public class StaticVariable {
  public class Penguin {
    String name;
    static String nameOfTallestPenguin;
  }

  public static void main(String[] args) {
    var p1 = new Penguin();
    p1.name = "Lilly";
  }
}
