package question0256;

/**
 * @author qianyihui
 * @date 2019-08-07
 *
 * 动态规划。
 *
 * 状态定义：
 * dp[i][0]:将第i号房子刷成红色的最小成本
 * dp[i][1]:将第i号房子刷成蓝色的最小成本
 * dp[i][2]:将第i号房子刷成绿色的最小成本
 *
 * 状态转移：
 * dp[0][0] = costs[0][0], dp[0][1] = costs[0][1], dp[0][2] = costs[0][2]
 *
 * dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0]
 * dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
 * dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为房子的数量。
 *
 * 执行用时：3ms，击败56.79%。消耗内存：37.2MB，击败100.00%。
 */
public class Solution1 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}
