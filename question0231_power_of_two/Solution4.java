package question0231_power_of_two;

public class Solution4 {

  public boolean isPowerOfTwo(int n) {
    return n > 0 && ((n & (n - 1)) == 0);
  }

}
