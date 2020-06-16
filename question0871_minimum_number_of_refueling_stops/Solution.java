package question0871_minimum_number_of_refueling_stops;

/**
 * 状态定义：
 * dp[i][j] 表示经过第 i - 1 个加油站，总共加 j 次油能够到达的最远距离
 *
 * 初始化条件：
 * dp[i][0] = startFuel。
 *
 * 状态转移方程：
 * 如果 dp[i - 1][j] >= stations[i - 1][0]，即经过第 i - 2 个加油站总共加 j 次油能够达到的最远距离大于等于 stations[i - 1][0]，
 * 那么 dp[i][j] 就可以取为 dp[i - 1][j]。
 * 如果 dp[i - 1][j - 1] >= stations[i - 1][0]，即在经过第 i - 2 个加油站总共加 j - 1 次
 * 油能够达到的最远距离大于等于 stations[i - 1][0]，那么 dp[i][j] 就可以取为 dp[i - 1][j - 1] + stations[i - 1][1]。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 2)，其中 n 为 stations 数组的长度。
 *
 * 执行用时：10ms，击败37.32%。消耗内存：47.4MB，击败11.11%。
 */
public class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        if (startFuel >= target) {
            return 0;
        }
        if (n == 0) {
            return -1;
        }
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = startFuel;
        }
        for (int j = 1; j < n + 1; j++) {
            for (int i = j; i < n + 1; i++) {
                if (dp[i - 1][j] >= stations[i - 1][0]) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (dp[i - 1][j - 1] >= stations[i - 1][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + stations[i - 1][1]);
                }
            }
            if (dp[n][j] >= target) {
                return j;
            }
        }
        return -1;
    }
}