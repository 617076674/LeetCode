package question0906_super_palindromes;

public class Solution {

  public int superpalindromesInRange(String left, String right) {
    long leftNum = Long.parseLong(left), rightNum = Long.parseLong(right);
    int result = 0;
    for (int k = 1; k < 100000; k++) {
      StringBuilder sb = new StringBuilder(Integer.toString(k));
      for (int i = sb.length() - 2; i >= 0; i--) {
        sb.append(sb.charAt(i));
      }
      long v = Long.parseLong(sb.toString());
      v *= v;
      if (v > rightNum) {
        break;
      }
      if (v >= leftNum && isPalindrome(v)) {
        result++;
      }
    }
    for (int k = 1; k < 100000; k++) {
      StringBuilder sb = new StringBuilder(Integer.toString(k));
      for (int i = sb.length() - 1; i >= 0; i--) {
        sb.append(sb.charAt(i));
      }
      long v = Long.parseLong(sb.toString());
      v *= v;
      if (v > rightNum) {
        break;
      }
      if (v >= leftNum && isPalindrome(v)) {
        result++;
      }
    }
    return result;
  }

  public static boolean isPalindrome(long x) {
    return x == reverse(x);
  }

  public static long reverse(long x) {
    long ans = 0;
    while (x > 0) {
      ans = 10 * ans + x % 10;
      x /= 10;
    }
    return ans;
  }

}