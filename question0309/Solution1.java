package question0309;

/**
 * @author qianyihui
 * @date 2019-07-23
 *
 * 动态规划。
 *
 * 状态定义：
 * dp[i][0]：第i天不持有股票的最大收益
 * dp[i][1]：第i天持有股票的最大收益
 *
 * 状态转移：
 * dp[0][0] = 0
 * dp[0][1] = -prices[0]
 * dp[1][1] = Math.max(-prices[0], -prices[1])
 *
 * 当i大于0且j == 0时
 * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
 *
 * 当i大于1且j == 1时
 * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i])
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为prices数组的长度。
 *
 * 执行用时：3ms，击败62.58%。消耗内存：35.4MB，击败82.73%。
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            if (i == 1) {
                dp[i][1] = Math.max(-prices[0], -prices[1]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
        }
        return dp[n - 1][0];
    }
}
