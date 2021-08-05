package question1937_maximum_number_of_points_with_cost;

import java.util.Arrays;

public class Solution {

  public long maxPoints(int[][] points) {
    int m = points.length, n = points[0].length;
    long result = Long.MIN_VALUE;
    Long[][] dp = new Long[m][n];
    for (int i = 0; i < n; i++) {
      dp[0][i] = (long) points[0][i];
    }
    for (int i = 1; i < m; i++) {
      long max = Long.MIN_VALUE;
      Arrays.fill(dp[i], 0L);
      for (int j = 0; j < n; j++) {
        max = Math.max(max, dp[i - 1][j] + j);
        dp[i][j] = Math.max(dp[i][j], max + points[i][j] - j);
      }
      max = Long.MIN_VALUE;
      for (int j = n - 1; j >= 0; j--) {
        max = Math.max(max, dp[i - 1][j] - j);
        dp[i][j] = Math.max(dp[i][j], max + points[i][j] + j);
      }
    }
    for (int i = 0; i < n; i++) {
      result = Math.max(result, dp[m - 1][i]);
    }
    return result;
  }

}