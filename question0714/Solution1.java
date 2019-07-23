package question0714;

/**
 * @author qianyihui
 * @date 2019-07-23
 *
 * 朴实无华版。
 *
 * 动态规划。
 *
 * 状态定义：
 * dp[i][0]：第i天不持有股票的最大收益
 * dp[i][1]：第i天持有股票的最大收益
 *
 * 状态转移：
 * dp[0][0] = 0
 * dp[0][1] = -prices[0] - fee
 *
 * 当i大于0且j == 0时
 * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
 *
 * 当i大于0且j == 1时
 * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee)
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为prices数组的长度。
 *
 * 执行用时：38ms，击败18.66%。消耗内存：57.2MB，击败80.91%。
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
