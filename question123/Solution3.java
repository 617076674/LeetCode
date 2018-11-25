package question123;

public class Solution3 {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (0 == prices.length) {
            return result;
        }
        int[][] dp = new int[3][prices.length];
        for(int k = 1; k <= 2; k++){
            dp[k][0] = 0;
            int min = prices[0];
            for(int i = 1; i < prices.length; i++){
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
                min = Math.min(min, prices[i] - dp[k - 1][i - 1]);
            }
        }
        return dp[2][prices.length - 1];
    }
}
