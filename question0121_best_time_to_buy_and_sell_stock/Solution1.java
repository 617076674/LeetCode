package question0121_best_time_to_buy_and_sell_stock;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n是prices数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：804ms，击败5.01%。消耗内存：40MB，击败17.51%。
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > result) {
                    result = prices[j] - prices[i];
                }
            }
        }
        return result;
    }
}