package question1987_number_of_unique_good_subsequences;

public class Solution {

  private static final int MOD = 1000000007;

  public int numberOfUniqueGoodSubsequences(String binary) {
    // dp[i][0]: 在 [i, binary.length() - 1] 范围内的子串中，以 0 开头的子序列的个数
    // dp[i][1]: 在 [i, binary.length() - 1] 范围内的子串中，以 1 开头的子序列的个数
    int[][] dp = new int[binary.length() + 1][2];
    boolean has0 = false;
    for (int i = binary.length() - 1; i >= 0; i--) {
      if (binary.charAt(i) == '0') {
        dp[i][0] = dp[i + 1][0] + dp[i + 1][1] + 1;
        dp[i][1] = dp[i + 1][1];
        has0 = true;
      } else {
        dp[i][0] = dp[i + 1][0];
        dp[i][1] = dp[i + 1][0] + dp[i + 1][1] + 1;
      }
      dp[i][0] %= MOD;
      dp[i][1] %= MOD;
    }
    return dp[0][1] + (has0 ? 1 : 0);
  }

}