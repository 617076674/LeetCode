package question042;

import java.util.Stack;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82682179
 */
public class Solution6 {

    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        if (n == 0 || n == 1) {
            return result;
        }
        int cur = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (cur < n) {
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                //distance represents the width
                int distance = cur - stack.peek() - 1;
                //tempHeight represents the height
                int tempHeight = Math.min(height[cur], height[stack.peek()]) - height[top];
                result += tempHeight * distance;
            }
            stack.push(cur);
            cur++;
        }
        return result;
    }
}
