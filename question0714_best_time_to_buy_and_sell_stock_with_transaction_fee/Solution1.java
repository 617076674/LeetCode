package question0714_best_time_to_buy_and_sell_stock_with_transaction_fee;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][0]：第 i 天未持有股票的最大收益。
 * dp[i][1]：第 i 天持有股票的最大收益。
 *
 * 初始化条件：
 * dp[0][0] = 0。
 * dp[0][1] = -prices[0] - fee。
 *
 * 状态转移方程：
 *（1）dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
 *（2）dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee)
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为prices数组的长度。
 *
 * 执行用时：24ms，击败30.66%。消耗内存：49.2MB，击败100.00%。
 */
public class Solution1 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[n - 1][0];
    }
}