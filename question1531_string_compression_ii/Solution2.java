package question1531_string_compression_ii;

import java.util.Arrays;

/**
 * 时间复杂度是 O((n ^ 2) * k)，其中 n 为字符串 s 的长度。空间复杂度是 O(n * k)。
 *
 * 执行用时：27ms，击败92.02%。消耗内存：39MB，击败45.25%。
 */
public class Solution2 {

  private int[][] memo;

  public int getLengthOfOptimalCompression(String s, int k) {
    memo = new int[s.length()][k + 1];
    for (int i = 0; i < s.length(); i++) {
      Arrays.fill(memo[i], -1);
    }
    return getLengthOfOptimalCompression(s, 0, k);
  }

  private int getLengthOfOptimalCompression(String s, int index, int k) {
    if (index + k >= s.length()) {
      return 0;
    }
    if (memo[index][k] != -1) {
      return memo[index][k];
    }
    int result = s.length();
    if (k > 0) {
      result = getLengthOfOptimalCompression(s, index + 1, k - 1);
    }
    int len = 0, same = 0, diff = 0;
    for (int i = index; i < s.length() && diff <= k; i++) {
      if (s.charAt(i) == s.charAt(index)) {
        same++;
        if (same <= 2 || same == 10 || same == 100) {
          len++;
        }
      } else {
        diff++;
      }
      if (diff <= k) {
        result = Math.min(result, len + getLengthOfOptimalCompression(s, i + 1, k - diff));
      }
    }
    memo[index][k] = result;
    return result;
  }

}