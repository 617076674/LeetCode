package question123;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int result = 0;
        if(0 == prices.length){
            return result;
        }
        int[][] dp = new int[2][prices.length];
        for(int k = 0; k < 2; k++){
            dp[k][0] = 0;
            int min = prices[0];
            for(int i = 1; i < prices.length; i++){
                for(int b = 1; b < i; b++){
                    if(k == 0){
                        min = Math.min(min, prices[b]);
                    }else{
                        min = Math.min(min, prices[b] - dp[k - 1][b - 1]);
                    }
                }
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }
        return dp[1][prices.length - 1];
    }
}