package question1621_number_of_sets_of_k_non_overlapping_line_segments;

public class Solution2 {

  private static final int MOD = 1000000007;

  public int numberOfSets(int n, int k) {
    int[][] dp = new int[n + 1][k + 1];
    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = 1;
    }
    for (int j = 1; j < k + 1; j++) {
      int sum = 0;
      for (int i = 1; i < n + 1; i++) {
        dp[i][j] = (sum + dp[i - 1][j]) % MOD;
        sum = (sum + dp[i][j - 1]) % MOD;
      }
    }
    return dp[n][k];
  }

}