package question084;

import java.util.Stack;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82991438
 */
public class Solution2 {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] newHeights = new int[n + 1];
        for (int i = 0; i < n; i++) {
            newHeights[i] = heights[i];
        }
        newHeights[n] = 0;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n + 1; i++) {
            while (!stack.isEmpty() && newHeights[stack.peek()] >= newHeights[i]) {
                int index = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                result = Math.max(result, newHeights[index] * (i - left - 1));
            }
            stack.push(i);
        }
        return result;
    }
}
