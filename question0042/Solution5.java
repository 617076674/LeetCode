package question0042;

import java.util.Stack;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82682179
 *
 * 我们的栈stack中存储的是height数组的索引。如果指针cur指向的height数组中的值小于等于栈顶元素或者栈为空，
 * 我们就一直入栈，因此我们栈顶元素索引对应的height数组的值是整个栈中最小的。一旦指针cur指向的height数组
 * 中的值超过栈顶的元素索引对应的height数组的值，就代表栈顶元素有一个右边界。由于栈中的元素都是递减的，所以
 * 如果存在一个比栈顶元素大的栈中元素，则一定可以确定该横向区域内的盛水量。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为height数组的长度。
 *
 * 执行用时：11ms，击败23.11%。消耗内存：39MB，击败71.14%。
 */
public class Solution5 {
    public int trap(int[] height) {
        int n = height.length, result = 0;
        if (n == 0 || n == 1) {
            return result;
        }
        int cur = 0;
        Stack<Integer> stack = new Stack<>();
        while (cur < n) {
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = cur - stack.peek() - 1;
                int tempHeight = Math.min(height[cur], height[stack.peek()]) - height[top];
                result += tempHeight * distance;
            }
            stack.push(cur);
            cur++;
        }
        return result;
    }
}
