package question0459_repeated_substring_pattern;

/**
 * KMP算法。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为字符串 s 的长度。
 *
 * 执行用时：400ms，击败5.80%。消耗内存：69.8MB，击败5.37%。
 */
public class Solution4 {
  public boolean repeatedSubstringPattern(String s) {
    return new KMPUtils(s).match((s + s).substring(1, s.length() * 2 - 1));
  }

  private static class KMPUtils {
    private int[][] dp;

    private String pattern;

    public KMPUtils(String pattern) {
      this.pattern = pattern;
      dp = new int[pattern.length()][256];
      dp[0][pattern.charAt(0)] = 1;
      int X = 0;
      for (int j = 1; j < pattern.length(); j++) {
        for (int c = 0; c < 256; c++) {
          dp[j][c] = dp[X][c];
        }
        dp[j][pattern.charAt(j)] = j + 1;
        X = dp[X][pattern.charAt(j)];
      }
    }

    public boolean match(String s) {
      int j = 0;
      for (int i = 0; i < s.length(); i++) {
        j = dp[j][s.charAt(i)];
        if (j == pattern.length()) {
          return true;
        }
      }
      return false;
    }
  }
}