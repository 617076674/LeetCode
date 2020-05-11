package question0122_best_time_to_buy_and_sell_stock_ii;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][0]：第i天不持有股票的最大收益。
 * dp[i][1]：第i天持有股票的最大收益。
 *
 * 初始化条件：
 * dp[0][0] = 0。
 * dp[0][1] = -prices[0]。
 *
 * 状态转移：
 * （1）当i大于0且j == 0时，dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])。
 * （2）当i大于0且j == 1时，dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i])。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为prices数组的长度。
 *
 * 执行用时：7ms，击败8.49%。消耗内存：39.6MB，击败17.14%
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (0 == n) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}