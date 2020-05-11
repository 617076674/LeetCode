package question0188_best_time_to_buy_and_sell_stock_iv;

/**
 * 状态定义：
 * dp[i][j][0]：第 i 天最多完成 j + 1 笔交易，且第 i 天未持有股票的最大收益。
 * dp[i][j][1]：第 i 天最多完成 j + 1 笔交易，且第 i 天持有股票的最大收益。
 *
 * 初始化条件：
 * dp[0][j][0] = 0。
 * dp[0][j][1] = -prices[0]。
 *
 * 状态转移方程：
 * （1）dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i])
 * （2）dp[i][0][1] = Math.max(dp[i - 1][0][1], -prices[i])
 * （3）dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i])
 *
 * 时间复杂度和空间复杂度均是O(kn)，其中n为prices数组的长度。
 *
 * 执行用时：10ms，击败55.94%。消耗内存：42MB，击败11.11%。
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int result = 0, n = prices.length;
        if (0 == n || k == 0) {
            return result;
        }
        //如果交易的次数足够多，相当于不受限，那么就可以记录每一个上升沿。
        if(k >= prices.length / 2){
            for (int i = 1; i < prices.length; i++) {
                if(prices[i] > prices[i - 1]){
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }
        int[][][] dp = new int[n][k][2];
        for (int i = 0; i < k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                if (j == 0) {
                    dp[i][0][1] = Math.max(dp[i - 1][0][1], -prices[i]);
                } else {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        return dp[n - 1][k - 1][0];
    }
}