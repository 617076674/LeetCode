package question123;

public class Solution5 {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (0 == prices.length) {
            return result;
        }
        int[] dp = new int[3];
        int[] min = new int[3];
        for(int i = 1; i < 3; i++){
            min[i] = prices[0];
        }
        for(int i = 1; i < prices.length; i++){
            for(int k = 1; k <= 2; k++){
                dp[k] = Math.max(dp[k], prices[i] - min[k]);
                min[k] = Math.min(min[k], prices[i] - dp[k - 1]);
            }
        }
        return dp[2];
    }
}
