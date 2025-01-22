import java.time.*;

public class Zoo {
  public static void main(String[] args) {
    var start = LocalDate.of(2025, Month.JANUARY, 1);
    var end = LocalDate.of(2025, Month.MARCH, 30);
    performAnimalEnrichment(start, end);
  }

  private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
    var upTo = start;

    while (upTo.isBefore(end)) {
      System.out.println("give new toy: " + upTo);
      upTo = upTo.plusMonths(1);
    }
  }
}
