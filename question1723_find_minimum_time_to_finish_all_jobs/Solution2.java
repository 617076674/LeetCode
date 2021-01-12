package question1723_find_minimum_time_to_finish_all_jobs;

/**
 * https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/submissions/
 */
public class Solution2 {

  public int minimumTimeRequired(int[] jobs, int k) {
    int n = jobs.length;
    int[] tot = new int[1 << n];
    for (int status = 1; status < (1 << n); status++) {
      for (int i = 0; i < n; i++) {
        if ((status & (1 << i)) != 0) {
          tot[status] = tot[(status - (1 << i))] + jobs[i];
          break;
        }
      }
    }
    int[][] dp = new int[k][1 << n];
    for (int i = 0; i < (1 << n); i++) {
      dp[0][i] = tot[i];
    }
    for (int i = 1; i < k; i++) {
      for (int status = 0; status < (1 << n); status++) {
        dp[i][status] = Integer.MAX_VALUE / 2;
        for (int j = status; j > 0; j = (j - 1) & status) {
          dp[i][status] = Math.min(dp[i][status], Math.max(dp[i - 1][status - j], tot[j]));
        }
      }
    }
    return dp[k - 1][(1 << n) - 1];
  }

}
