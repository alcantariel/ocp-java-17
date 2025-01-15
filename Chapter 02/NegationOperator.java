public class NegationOperator {
  public static void main(String[] args) {
    double zooTemperature = 1.21;
    System.out.println(zooTemperature); // 1.21

    zooTemperature = -zooTemperature;
    System.out.println(zooTemperature); // -1.21

    zooTemperature = -(-zooTemperature);
    System.out.println(zooTemperature); // -1.21
  }
}
