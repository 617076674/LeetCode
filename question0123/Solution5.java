package question0123;

/**
 * 神仙看不懂版。（Solution4的精简）
 *
 * 时间复杂度是O(n)，其中n为prices数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败88.52%。消耗内存：39.2MB，击败41.01%
 */
public class Solution5 {
    public int maxProfit(int[] prices) {
        int result = 0, n = prices.length;
        if (0 == n) {
            return result;
        }
        int state1 = 0, state2 = -prices[0], state3 = 0, state4 = -prices[0];
        for (int i = 1; i < n; i++) {
            state3 = Math.max(state3, state4 + prices[i]);
            state4 = Math.max(state4, state1 - prices[i]);
            state1 = Math.max(state1, state2 + prices[i]);
            state2 = Math.max(state2, -prices[i]);
        }
        return state3;
    }
}
