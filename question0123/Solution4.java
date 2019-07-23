package question0123;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j][0]：第i天最多完成j + 1笔交易，且第i天持有股票的最大收益
 * dp[i][j][1]：第i天最多完成j + 1笔交易，且第i天持有股票的最大收益
 *
 * 状态转移：
 * dp[0][0][0] = 0
 * dp[0][0][1] = -prices[0]
 * dp[0][1][0] = 0
 * dp[0][1][1] = -prices[0]
 *
 * 当i大于0且k == 0时
 * dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i])
 *
 * 当i大于0且k == 1时
 *        当j == 0时
 *             dp[i][0][1] = Math.max(dp[i - 1][j][1], -prices[i])
 *        当j > 0时
 *             dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i])
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为prices数组的长度。
 *
 * 执行用时：9ms，击败41.29%。消耗内存：37.2MB，击败82.02%
 */
public class Solution4 {
    public int maxProfit(int[] prices) {
        int result = 0, n = prices.length;
        if (0 == n) {
            return result;
        }
        int[][][] dp = new int[n][2][2];
        dp[0][0][0] = dp[0][1][0] = 0;
        dp[0][0][1] = dp[0][1][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                if (j == 0) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], -prices[i]);
                } else {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        return dp[n - 1][1][0];
    }
}
