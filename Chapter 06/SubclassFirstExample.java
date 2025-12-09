public class SubclassFirstExample {
  public class BigCat {
    protected double size;
  }

  public class Jaguar extends BigCat {
    public Jaguar() {
      size = 10.2;
    }

    public void printDetails() {
      System.out.println(size);
    }
  }

  public class Spider {
    public void printDetails() {
      System.out.println(size);
    }
  }
}
