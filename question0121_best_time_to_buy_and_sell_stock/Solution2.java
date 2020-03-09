package question0121_best_time_to_buy_and_sell_stock;

/**
 * 记录[0, x - 1]天的最小值。
 *
 * 时间复杂度是O(n)，其中n是prices数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败43.49%。消耗内存：38.3MB，击败51.91%。
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int result = 0, n = prices.length;
        if (0 == n) {
            return result;
        }
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            result = Math.max(result, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return result;
    }
}