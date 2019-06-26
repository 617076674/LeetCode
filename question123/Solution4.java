package question123;

public class Solution4 {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (0 == prices.length) {
            return result;
        }
        int[][] dp = new int[3][prices.length];
        int[] min = new int[3];
        for (int i = 1; i < 3; i++) {
            min[i] = prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k <= 2; k++) {
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min[k]);
                min[k] = Math.min(min[k], prices[i] - dp[k - 1][i - 1]);
            }
        }
        return dp[2][prices.length - 1];
    }
}
