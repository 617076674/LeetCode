package question0084_largest_rectangle_in_histogram;

import java.util.Stack;

/**
 * 单调递增栈。
 *
 * 操作规则：
 * 如果新的元素比栈顶元素大，则入栈；否则，一直弹出栈顶元素直到栈顶元素比新的元素小。
 *
 * 效果：
 * 当元素出栈时，说明这个新元素是当前出栈元素向后找的第一个比其小的元素。
 * 当元素出栈后，说明新的栈顶元素是出栈元素向前找的第一个比其小的元素。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为 heights 数组的长度。
 *
 * 执行用时：11ms，击败90.14%。消耗内存：41.2MB，击败39.13%。
 */
public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int index = stack.pop(), left = stack.isEmpty() ? -1 : stack.peek();
                result = Math.max(result, heights[index] * (i - left - 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop(), left = stack.isEmpty() ? -1 : stack.peek();
            result = Math.max(result, heights[index] * (n - left - 1));
        }
        return result;
    }
}