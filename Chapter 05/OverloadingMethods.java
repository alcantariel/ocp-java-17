public class OverloadingMethods {
  public static void main(String[] args) {
    Falcon falcon = new Falcon();
    falcon.fly(1);
    falcon.fly((short) 123);
    falcon.fly();
    falcon.fly(123, (short) 123);
    try {
      falcon.fly((short) 123, 123);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static class Falcon {
    public void fly(int numMiles) {
      System.out.println("Flying " + numMiles + " miles");
    }

    public void fly(short numFeet) {
      System.out.println("Flying " + numFeet + " feet");
    }

    public boolean fly() {
      System.out.println("Flying");
      return false;
    }

    public void fly(int numMiles, short numFeet) {
      System.out.println("Flying " + numMiles + " miles and " + numFeet + " feet");
    }

    public void fly(short numFeet, int numMules) throws Exception {
      System.out.println("Flying " + numFeet + " feet and " + numMules + " miles");
    }
  }
}
