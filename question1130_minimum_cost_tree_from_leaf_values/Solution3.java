package question1130_minimum_cost_tree_from_leaf_values;

import java.util.Stack;

/**
 * 单调栈。
 *
 * 将原问题转化为下述问题：
 * 在数组 arr 中，每次取相邻的两个数 arr[i] 和 arr[i + 1]，然后去掉其中较小的一个，花费代价为 arr[i] * arr[i + 1]，
 * 求最终将数组消减为一个元素的最小代价。
 *
 * 贪心策略：对于数组中的某一个数 arr[i]，分别向左和向右查询比它大的第一个数，在这两个数中选择较小的那个数把它消去，花费的代价最小。
 *
 * 维护一个单调递减栈，初始时栈中有一个元素 Integer.MAX_VALUE。
 *
 * 数组 arr 中的每一个元素都是要入一次栈的。
 *
 * 对于某个数 arr[i]，其左侧比它大的值就是弹出 arr[i] 后的栈顶元素，其右侧比它大的值就是 num。
 *
 * 如果数组 arr 是一个递减排列的数组，比如 arr = {4, 2, 1}，那么存在光入栈，不出栈的情况。因此在最后需要统一做出栈处理。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为 arr 数组的长度。
 *
 * 执行用时：1ms，击败97.86%。消耗内存：37.4MB，击败100.00%。
 */
public class Solution3 {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int result = 0;
        for (int num : arr) {
            while (stack.peek() < num) {
                result += stack.pop() * Math.min(stack.peek(), num);
            }
            stack.push(num);
        }
        while (stack.size() > 2) {
            result += stack.pop() * stack.peek();
        }
        return result;
    }
}