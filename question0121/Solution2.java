package question0121;

/**
 * f(x)：当第x天卖出时能获得的最大利润。
 *
 * 只需用一个变量minPrice记录[0, x - 1]天的最小值即可。
 *
 * 时间复杂度是O(n)，其中n是prices数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败43.49%。消耗内存：38.3MB，击败51.91%。
 */
public class Solution2 {
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
