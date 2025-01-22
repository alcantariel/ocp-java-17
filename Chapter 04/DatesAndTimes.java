import java.time.*;

public class DatesAndTimes {
  public static void main(String[] args) {
    // LocalDate
    var date1 = LocalDate.of(2025, 1, 22);
    var date2 = LocalDate.of(2025, Month.JANUARY, 22);

    // LocalTime
    var time1 = LocalTime.of(7, 5);
    var time2 = LocalTime.of(7, 5, 30);
    var time3 = LocalTime.of(7, 5, 30, 200);

    // LocalDateTime
    var dateTime1 = LocalDateTime.of(2025, Month.JANUARY, 22, 7, 5, 30);
    var dateTime2 = LocalDateTime.of(date1, time1);

    // ZonedDateTime
    var zone = ZoneId.of("America/Sao_Paulo");
    var zoned1 = ZonedDateTime.of(2025, 1, 22, 7, 5, 30, 200, zone);
    var zoned2 = ZonedDateTime.of(date1, time1, zone);
    var zoned3 = ZonedDateTime.of(dateTime1, zone);
  }
}
