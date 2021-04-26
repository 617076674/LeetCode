package question0087_scramble_string;

public class Solution {

  public boolean isScramble(String s1, String s2) {
    int n1 = s1.length(), n2 = s2.length();
    if (n1 != n2) {
      return false;
    }
    // dp[i][j][k] 表示 s1 中 [i, i + k - 1] 范围内的子串是否是 s2 中 [j, j + k - 1] 范围内的子串的扰乱串
    boolean[][][] dp = new boolean[n1][n1][n1 + 1];
    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < n1; j++) {
        dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
      }
    }
    for (int len = 2; len <= n1; len++) {
      for (int i = 0; i < n1 - len + 1; i++) {
        for (int j = 0; j < n1 - len + 1; j++) {
          for (int k = 1; k < len; k++) {
            if (dp[i][j][len]) {
              continue;
            }
            if ((dp[i][j][k] && dp[i + k][j + k][len - k]) || (dp[i][j + len - k][k] && dp[i + k][j][len - k])) {
              dp[i][j][len] = true;
              break;
            }
          }
        }
      }
    }
    return dp[0][0][n1];
  }

}