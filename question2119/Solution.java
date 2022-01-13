package question2119;

public class Solution {

  public boolean isSameAfterReversals(int num) {
    return num == reverse(reverse(num));
  }

  private static int reverse(int num) {
    int result = 0;
    while (num > 0) {
      int digit = num % 10;
      result = result * 10 + digit;
      num /= 10;
    }
    return result;
  }

}
