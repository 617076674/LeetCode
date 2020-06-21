package question1475_final_prices_with_a_special_discount_in_a_shop;

import java.util.Stack;

/**
 * 单调栈。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为数组 prices 的长度。
 *
 * 执行用时：4ms，击败17.74%。消耗内存：39.7MB，击败100.00%
 */
public class Solution2 {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                result[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = prices[index];
        }
        return result;
    }
}