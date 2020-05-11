package lcof63_gu_piao_de_zui_da_li_run;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n是prices数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：302ms，击败6.82%。消耗内存：39.7MB，击败100.00%。
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