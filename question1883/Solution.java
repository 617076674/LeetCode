package question1883;

import java.util.Arrays;

public class Solution {

  public int minSkips(int[] dist, int speed, int hoursBefore) {
    int[][] dp = new int[dist.length + 1][dist.length + 1];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
    }
    dp[0][0] = 0;
    for (int i = 1; i <= dist.length; i++) {
      for (int j = 0; j <= i; j++) {
        if (i != j) {
          dp[i][j] = Math.min(dp[i][j], ((dp[i - 1][j] - 1 + dist[i - 1]) / speed + 1) * speed);
        }
        if (j != 0) {
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + dist[i - 1]);
        }
      }
    }
    for (int i = 0; i <= dist.length; i++) {
      if (dp[dist.length][i] <= 1L * hoursBefore * speed) {
        return i;
      }
    }

    return -1;
  }

}