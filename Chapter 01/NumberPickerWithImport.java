import java.util.Random; // import tells java where to find Random

public class NumberPickerWithImport {
  public static void main(String[] args) {
    Random r = new Random();
    System.out.println(r.nextInt(10)); // a number 0-9
  }
}
