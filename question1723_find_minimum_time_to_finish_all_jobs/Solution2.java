package question1723_find_minimum_time_to_finish_all_jobs;

public class Solution2 {

  public int minimumTimeRequired(int[] jobs, int k) {
    int n = jobs.length;
    int[][] dp = new int[k][1 << n];
    for (int i = 0; i < dp[0].length; i++) {
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0) {
          dp[0][i] += jobs[j];
        }
      }
    }
    for (int i = 1; i < k; i++) {
      for (int status = 0; status < (1 << n); status++) {
        dp[i][status] = Integer.MAX_VALUE / 2;
        for (int j = status; j > 0; j = (j - 1) & status) {
          if (j == status) {
            continue;
          }
          dp[i][status] = Math.min(dp[i][status], Math.max(dp[i - 1][status - j], dp[0][j]));
        }
      }
    }
    return dp[k - 1][(1 << n) - 1];
  }

}