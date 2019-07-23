package question0123;

/**
 * 做两次question0121。
 *
 * 时间复杂度是O(n ^ 2)，其中n为prices数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：870ms，击败5.01%。消耗内存：39.7MB，击败30.34%。
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int result = 0, n = prices.length;
        if (n == 0) {
            return result;
        }
        for (int i = 1; i < n; i++) {
            //第一笔交易在[0, i]天内完成，第二笔交易在[i + 1, n - 1]天内完成
            result = Math.max(maxProfit(prices, 0, i) + maxProfit(prices, i + 1, n - 1), result);
        }
        return result;
    }

    private int maxProfit(int[] prices, int left, int right) {
        int result = 0;
        if (right - left < 1) {
            return result;
        }
        int minPrice = prices[left];
        for (int i = left + 1; i <= right; i++) {
            result = Math.max(result, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return result;
    }
}