public class CallingMethods {
  public static void main(String[] args) {
    var name = new StringBuilder("Webby");
    speak(name);
    System.out.println(name); // WebbyGeorgette
  }

  public static void speak(StringBuilder s) {
    s.append("Georgette");
  }
}
