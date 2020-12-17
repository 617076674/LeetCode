package question0738_monotone_increasing_digits;

/**
 * 贪心算法。
 *
 * 时间复杂度是 O(logN)。空间复杂度是 O(1)。
 */
public class Solution2 {

  public int monotoneIncreasingDigits(int N) {
    StringBuilder sb = new StringBuilder(String.valueOf(N));
    int i = 1;
    while (i < sb.length() && sb.charAt(i - 1) <= sb.charAt(i)) {
      i++;
    }
    if (i < sb.length()) {
      while (i > 0 && sb.charAt(i - 1) > sb.charAt(i)) {
        sb.setCharAt(i - 1, (char) (sb.charAt(i - 1) - 1));
        i--;
      }
      i++;
      while (i < sb.length()) {
        sb.setCharAt(i, '9');
        i++;
      }
    }
    return Integer.parseInt(sb.toString());
  }

}
