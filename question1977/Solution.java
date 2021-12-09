package question1977;

public class Solution {

  private static final int MOD = 1000000007;

  public int numberOfCombinations(String num) {
    // 从索引 i 开始和从索引 j 开始的子串，其最长公共前缀的长度为 lcs[i][j]
    int[][] lcs = new int[num.length()][num.length()];
    for (int i = num.length() - 1; i >= 0; i--) {
      for (int j = i; j < num.length(); j++) {
        if (num.charAt(i) == num.charAt(j)) {
          lcs[i][j] = 1;
          if (i + 1 < num.length() && j + 1 < num.length()) {
            lcs[i][j] += lcs[i + 1][j + 1];
          }
        }
      }
    }
    int[][] dp = new int[num.length() + 1][num.length()];
    for (int len = 1; len <= num.length(); len++) {
      for (int lastIndex = 0; lastIndex < num.length(); lastIndex++) {
        dp[len][lastIndex] = dp[len - 1][lastIndex];
        if (lastIndex + 1 - len >= 0 && num.charAt(lastIndex - len + 1) != '0') {
          if (len == lastIndex + 1) {
            dp[len][lastIndex]++;
          } else {
            int temp = lastIndex - 2 * len + 1;
            if (temp >= 0 && num.charAt(temp) != '0') {
              int commonLen = lcs[temp][lastIndex - len + 1];
              if (commonLen >= len
                  || num.charAt(temp + commonLen) < num.charAt(lastIndex - len + 1 + commonLen)) {
                dp[len][lastIndex] += dp[len][lastIndex - len];
              } else {
                dp[len][lastIndex] += dp[len - 1][lastIndex - len];
              }
            } else {
              dp[len][lastIndex] += dp[len - 1][lastIndex - len];
            }
          }
        }
        dp[len][lastIndex] %= MOD;
      }
    }
    return dp[num.length()][num.length() - 1];
  }

}