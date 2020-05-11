package lcof63_gu_piao_de_zui_da_li_run;

/**
 * 记录[0, x - 1]天的最小值。
 *
 * 时间复杂度是O(n)，其中n是prices数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败63.77%。消耗内存：39.7MB，击败100.00%。
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