public class LogicalComplementOperator {
  public static void main(String[] args) {
    boolean isAnimalAsleep = false;
    System.out.println(isAnimalAsleep); // false

    isAnimalAsleep = !isAnimalAsleep;
    System.out.println(isAnimalAsleep); // true
  }
}
