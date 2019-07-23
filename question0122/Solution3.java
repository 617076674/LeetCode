package question0122;

/**
 * 神仙看不懂版。（Solution2的精简）
 *
 * 时间复杂度是O(n)，其中n为prices数组的长度。空间复杂度是O(1)
 *
 * 执行用时：4ms，击败8.49%。消耗内存：37.9MB，击败42.29%
 */
public class Solution3 {
    public int maxProfit(int[] prices) {
        int result = 0, n = prices.length;
        if (0 == n) {
            return result;
        }
        int state1 = 0, state2 = -prices[0];
        for (int i = 1; i < n; i++) {
            int newState1 = Math.max(state1, state2 + prices[i]);
            int newState2 = Math.max(state2, state1 - prices[i]);
            state1 = newState1;
            state2 = newState2;
        }
        return state1;
    }
}
