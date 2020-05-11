package question0122_best_time_to_buy_and_sell_stock_ii;

/**
 * 贪心算法，只要遇到上升沿就买。
 *
 * 时间复杂度是O(n)，其中n是prices数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败97.84%。消耗内存：38.9MB，击败26.22%
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]){
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }
}