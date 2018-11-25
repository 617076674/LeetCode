package question121;

public class Solution1 {
    public int maxProfit(int[] prices) {
        int result = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] - prices[i] > result){
                    result = prices[j] - prices[i];
                }
            }
        }
        return result;
    }
}
