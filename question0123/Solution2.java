package question0123;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j]:
 *
 * 第i笔交易（假设第一笔交易编号为0），在第j天所能取得的最大利润。
 *
 * 当i == 0时，说明这是第一笔交易。
 *     当j == 0时，说明这是第一天，我们不可能取得利润，即dp[0][0] = 0。
 *     当j > 0时，我们可以选择在第j天不卖出股票，此时第j天的利润一定和第j - 1天的利润相同，即dp[0][j] = dp[0][j - 1]。
 *               我们也可以选择在第j天卖出股票，此时第j天的利润为Math.max(prices[j] - prices[b])，其中b∈[0, j - 1]。
 * 当i == 1时，说明这是第二笔交易。
 *     当j == 0时，说明这是第一天，我们不可能取得利润，即dp[1][0] = 0，实际上这时候第一笔交易都不可能发生，第二笔交易更不可能发生了。
 *     当j > 0时，我们可以选择在第j天不卖出股票，此时第j天的利润一定和第j - 1天的利润相同，即dp[1][j] = dp[1][j - 1]。
 *               我们也可以选择在第j天卖出股票，此时第j天的利润为Math.max(prices[j] - prices[b] + dp[0][b - 1])，其中b∈[0, j - 1]。
 *
 * 时间复杂度是O(n ^ 2)，其中n是prices数组的长度。空间复杂度是O(n)。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int result = 0, n = prices.length;
        if (0 == n) {
            return result;
        }
        int[][] dp = new int[2][n];
        for (int i = 0; i < 2; i++) {
            dp[i][0] = 0;
            int min = prices[0];
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < j; k++) {
                    if (i == 0) {
                        min = Math.min(min, prices[k]);
                    } else {
                        min = Math.min(min, prices[k] - dp[i - 1][k - 1]);
                    }
                }
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - min);
            }
        }
        return dp[1][n - 1];
    }
}