package question0309;

/**
 * @author qianyihui
 * @date 2019-07-23
 *
 * 神仙看不懂版。（Solution1的精简）
 *
 * 时间复杂度是O(n)，其中n为prices数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：34.9MB，击败85.14%。
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int state1 = 0, state2 = -prices[0], state3 = 0;
        for (int i = 1; i < n; i++) {
            int newState1 = Math.max(state1, state2 + prices[i]);
            if (i == 1) {
                state2 = Math.max(-prices[0], -prices[1]);
            } else {
                int newState2 = Math.max(state2, state3 - prices[i]);
                state3 = state1;
                state2 = newState2;
            }
            state1 = newState1;
        }
        return state1;
    }

}
