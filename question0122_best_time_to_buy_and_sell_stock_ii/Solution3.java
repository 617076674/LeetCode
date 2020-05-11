package question0122_best_time_to_buy_and_sell_stock_ii;

/**
 * 状态压缩。
 *
 * 时间复杂度是O(n)，其中n为prices数组的长度。空间复杂度是O(1)
 *
 * 执行用时：4ms，击败8.49%。消耗内存：37.9MB，击败42.29%
 */
public class Solution3 {
    public int maxProfit(int[] prices) {
        int state1 = 0, state2 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int newState1 = Math.max(state1, state2 + prices[i]);
            int newState2 = Math.max(state2, state1 - prices[i]);
            state1 = newState1;
            state2 = newState2;
        }
        return state1;
    }
}