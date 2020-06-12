package question0568_maximum_vacation_days;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是 O(K * N ^ 2)。空间复杂度是 O(K * N)。
 *
 * 执行用时：75ms，击败42.91%。消耗内存：41.1MB，击败100.00%。
 */
public class Solution2 {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int[][] dp = new int[days.length][days[0].length + 1];
        for (int j = days[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < days.length; i++) {
                dp[i][j] = days[i][j] + dp[i][j + 1];
                for (int k = 0; k < flights.length; k++) {
                    if (flights[i][k] == 1) {
                        dp[i][j] = Math.max(dp[i][j], days[k][j] + dp[k][j + 1]);
                    }
                }
            }
        }
        return dp[0][0];
    }
}