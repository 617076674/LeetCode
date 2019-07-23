package question0188;

/**
 * 状态定义：
 * dp[i][j][0]：第i天最多完成j + 1笔交易，且第i天持有股票的最大收益
 * dp[i][j][1]：第i天最多完成j + 1笔交易，且第i天持有股票的最大收益
 *
 * 状态转移：
 * 当i == 0且k == 0时，dp[0][j][0] = 0
 * 当i == 0且k == 1时，dp[0][j][1] = -prices[0]
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
 * 时间复杂度和空间复杂度均是O(kn)，其中n为prices数组的长度。
 *
 * 执行用时：18ms，击败23.25%。消耗内存：40.2MB，击败5.34%。
 */
public class Solution2 {
    public int maxProfit(int k, int[] prices) {
        int result = 0, n = prices.length;
        if (0 == n || k == 0) {
            return result;
        }
        //如果交易的次数足够多，相当于不受限，那么就可以对每一个上升沿都进行一次交易。
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


