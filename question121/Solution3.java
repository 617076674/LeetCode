package question121;

public class Solution3 {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (0 == prices.length) {
            return result;
        }
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return result;
    }
}
