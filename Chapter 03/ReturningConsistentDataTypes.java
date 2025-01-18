public class ReturningConsistentDataTypes {
  public static void main(String[] args) {
    int measurement = 10;
    int size = switch (measurement) {
      case 5 -> 1;
      case 10 -> (short) 2; // short can be implicitly cast to an int
      default -> 5;

      // each return type cannot be assigned to the int variable
      case 20 -> "3"; // DOES NOT COMPILE
      case 40 -> 4L; // DOES NOT COMPILE
      case 50 -> null; // DOES NOT COMPILE
    };
  }
}
