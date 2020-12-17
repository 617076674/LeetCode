package question0084_largest_rectangle_in_histogram;

import java.util.LinkedList;
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
        int result = 0;
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = newHeights[heights.length + 1] = -1;
        for (int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int index = stack.pop();
                result = Math.max(result, newHeights[index] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return result;
    }
}