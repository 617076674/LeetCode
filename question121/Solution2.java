package question121;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int result = 0;
        if(prices.length == 0){
            return result;
        }
        int[] dp = new int[prices.length];
        dp[0] = Integer.MAX_VALUE;
        for(int i = 1; i < dp.length; i++){
            if(prices[i - 1] < dp[i - 1]){
                dp[i] = prices[i - 1];
            }else{
                dp[i] = dp[i - 1];
            }
        }
        for(int i = 1; i < dp.length; i++){
            if(prices[i] - dp[i] > result){
                result = prices[i] - dp[i];
            }
        }
        return result;
    }
}
