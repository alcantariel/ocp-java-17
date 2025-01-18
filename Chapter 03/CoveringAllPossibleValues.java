enum Season {
  WINTER,
  SPRING,
  SUMMER,
  FALL
}

public class CoveringAllPossibleValues {
  public static void main(String[] args) {
    var weather = getWeather(Season.SPRING);

    System.out.println(weather); // Rainy
  }

  static String getWeather(Season season) {
    return switch (season) {
      case WINTER -> "Cold";
      case SPRING -> "Rainy";
      case SUMMER -> "Hot";
      case FALL -> "Warm";
    };
  }
}
