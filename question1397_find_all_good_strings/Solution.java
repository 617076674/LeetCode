package question1397_find_all_good_strings;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 数位 DP + KMP
 *
 * 时间复杂度和空间复杂度均为 O(n * m)，其中 m 为字符串 evil 的长度。
 *
 * 执行用时：27ms，击败84.09%。消耗内存：38.8MB，击败28.21%。
 */
public class Solution {

  private static final int MOD = 1000000007;

  private int[][][] memo;

  private KMPUtils kmpUtils;

  public int findGoodStrings(int n, String s1, String s2, String evil) {
    memo = new int[n][evil.length()][4];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < evil.length(); j++) {
        Arrays.fill(memo[i][j], -1);
      }
    }
    kmpUtils = new KMPUtils(evil);
    return findGoodStrings(s1, s2, evil, 0, 0, 3);
  }

  /**
   * 我们正在考虑字符串 s1 和 s2 中第 index 个字符，[0, index - 1] 范围内的字符构成的状态为 status，
   * 此次选择需要紧贴 s1.charAt(index) 和 s2.charAt(index)。
   */
  private int findGoodStrings(String s1, String s2, String evil, int index, int status, int bound) {
    if (status == evil.length()) {
      return 0;
    }
    if (index == s1.length()) {
      return 1;
    }
    if (memo[index][status][bound] != -1) {
      return memo[index][status][bound];
    }
    memo[index][status][bound] = 0;
    int left = (bound == 1 || bound == 3) ? (s1.charAt(index) - 'a') : 0;
    int right = (bound == 2 || bound == 3) ? (s2.charAt(index) - 'a') : 25;
    for (int i = left; i <= right; i++) {
      char c = (char) ('a' + i);
      int nextStatus = kmpUtils.dp[status][c];
      int nextBound = getNextBound(s1, s2, index + 1, c, bound);
      memo[index][status][bound] += findGoodStrings(s1, s2, evil, index + 1, nextStatus, nextBound);
      memo[index][status][bound] %= MOD;
    }
    return memo[index][status][bound];
  }

  /**
   * 第 index - 1 个字符选择了 c，第 index 字符的 bound 如何取值？
   * bound 为 0，表示可以取 'a' - 'z'
   * bound 为 1，表示可以取 s1.charAt(index) - 'z'
   * bound 为 2，表示可以取 'a' - s2.charAt(index)
   * bound 为 3，表示可以取 s1.charAt(index) - s2.charAt(index)
   */
  private int getNextBound(String s1, String s2, int index, char c, int bound) {
    switch (bound) {
      case 0:
        return 0;
      case 1:
        if (c == s1.charAt(index - 1)) {
          return 1;
        }
        return 0;
      case 2:
        if (c == s2.charAt(index - 1)) {
          return 2;
        }
        return 0;
      default:
        if (c == s1.charAt(index - 1)) {
          if (c == s2.charAt(index - 1)) {
            return 3;
          }
          return 1;
        }
        if (c == s2.charAt(index - 1)) {
          return 2;
        }
        return 0;
    }
  }

  private static class KMPUtils {

    private int[][] dp;

    public KMPUtils(String pattern) {
      dp = new int[pattern.length()][256];
      dp[0][pattern.charAt(0)] = 1;
      int X = 0;
      for (int j = 1; j < pattern.length(); j++) {
        System.arraycopy(dp[X], 0, dp[j], 0, 256);
        dp[j][pattern.charAt(j)] = j + 1;
        X = dp[X][pattern.charAt(j)];
      }
    }

  }

}