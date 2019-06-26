package question188;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int result = 0;
        if (0 == prices.length || 0 == k) {
            return result;
        }
        if (k >= prices.length / 2) {
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }
        int[][] dp = new int[2][prices.length];
        for (int t = 0; t < k; t++) {
            int cur = t % 2;
            int pre = 1 - cur;
            dp[cur][0] = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[cur][i] = Math.max(dp[cur][i - 1], prices[i] - min);
                if (t == 0) {
                    min = Math.min(min, prices[i]);
                } else {
                    min = Math.min(min, prices[i] - dp[pre][i - 1]);
                }
            }
            if (result == dp[cur][prices.length - 1]) {
                break;
            }
            result = dp[cur][prices.length - 1];
        }
        return result;
    }
}

