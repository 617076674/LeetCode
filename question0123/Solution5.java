package question0123;

/**
 * 神仙看不懂版。（Solution4的精简）
 *
 * 时间复杂度是O(n)，其中n为prices数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：6ms，击败52.56%。消耗内存：38.8MB，击败44.66%
 */
public class Solution5 {
    public int maxProfit(int[] prices) {
        int result = 0, n = prices.length;
        if (0 == n) {
            return result;
        }
        int state1 = 0, state2 = -prices[0], state3 = 0, state4 = -prices[0];
        for (int i = 1; i < n; i++) {
            int newState1 = Math.max(state1, state2 + prices[i]);
            int newState2 = Math.max(state2, -prices[i]);
            int newState3 = Math.max(state3, state4 + prices[i]);
            int newState4 = Math.max(state4, state1 - prices[i]);
            state1 = newState1;
            state2 = newState2;
            state3 = newState3;
            state4 = newState4;
        }
        return state3;
    }
}
