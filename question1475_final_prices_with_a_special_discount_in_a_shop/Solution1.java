package question1475_final_prices_with_a_special_discount_in_a_shop;

/**
 * 暴力破解法。
 *
 * 时间复杂度是 O(n ^ 2)，其中 n 为数组 prices 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：40MB，击败100.00%
 */
public class Solution1 {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            result[i] = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    result[i] -= prices[j];
                    break;
                }
            }
        }
        return result;
    }
}