package question0714_best_time_to_buy_and_sell_stock_with_transaction_fee;

/**
 * 状态压缩。
 *
 * 时间复杂度是O(n)，其中n为prices数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：13ms，击败52.53%。消耗内存：73.3MB，击败15.45%。
 */
public class Solution2 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int state1 = 0, state2 = -prices[0] - fee;
        for (int i = 1; i < n; i++) {
            int newState1 = Math.max(state1, state2 + prices[i]);
            int newState2 = Math.max(state2, state1 - prices[i] - fee);
            state1 = newState1;
            state2 = newState2;
        }
        return state1;
    }
}