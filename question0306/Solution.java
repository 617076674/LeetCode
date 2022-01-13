package question0306;

public class Solution {

  public boolean isAdditiveNumber(String num) {
    for (int i = 0; i < num.length() - 2; i++) {
      if (num.charAt(0) == '0' && i > 0) {
        continue;
      }
      for (int j = i + 1; j < num.length() && num.length() - 1 - j >= Math.max(i + 1, j - i); j++) {
        if (num.charAt(i + 1) == '0' && j - i > 1) {
          continue;
        }
        long num1 = Long.parseLong(num.substring(0, i + 1));
        long num2 = Long.parseLong(num.substring(i + 1, j + 1));
        if (check(num1, num2, j + 1, num)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean check(long num1, long num2, int index, String num) {
    if (index == num.length()) {
      return true;
    }
    long nextNum = num1 + num2;
    String pre = String.valueOf(nextNum);
    if (!num.substring(index).startsWith(pre)) {
      return false;
    }
    return check(num2, nextNum, index + pre.length(), num);
  }

}