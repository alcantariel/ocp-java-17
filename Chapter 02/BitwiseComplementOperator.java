public class BitwiseComplementOperator {
  public static void main(String[] args) {
    int value = 3; // stored as 0011 where the first 0 is the signal + and 011 is the binary value
    int complement = ~value; // stored as 1100 where the first 1 is the signal - and 100 is the binary value

    // binary <-> decimal (8 bit)
    // 128 64 32 16 8 4 2 1
    // --------------------
    // 0 0 0 0 0 0 1 1 = 3
    // 0 0 0 0 0 1 0 0 = 4

    System.out.println(value); // 3
    System.out.println(complement); // -4

    // to find the bitwise complement of a number
    // multiply it by negative one and then subtract one

    System.out.println((-1 * value) - 1); // -4
    System.out.println((-1 * complement) - 1); // 3
  }
}
