public class OrderOfInitialization {
  private String name = "Travis"; // 1, initialization
  { System.out.println("setting field"); }

  public OrderOfInitialization() {
    name = "Abel"; // 2, because the new
    { System.out.println("setting constructor"); }
  }

  public static void main(String[] args) {
    OrderOfInitialization order = new OrderOfInitialization();
    System.out.println(order.name); // prints the name
  }
}
