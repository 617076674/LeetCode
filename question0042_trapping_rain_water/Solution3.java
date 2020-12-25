package question0042_trapping_rain_water;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 单调递减栈。
 *
 * 我们的栈stack中存储的是height数组的索引。如果指针cur指向的height数组中的值小于等于栈顶元素或者栈为空，
 * 我们就一直入栈，因此我们栈顶元素索引对应的height数组的值是整个栈中最小的。一旦指针cur指向的height数组
 * 中的值超过栈顶的元素索引对应的height数组的值，就代表栈顶元素有一个右边界。由于栈中的元素都是递减的，所以
 * 如果存在一个比栈顶元素大的栈中元素，则一定可以确定该横向区域内的盛水量。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为height数组的长度。
 *
 * 执行用时：7ms，击败32.86%。消耗内存：36.4MB，击败90.64%。
 */
public class Solution3 {

    public int trap(int[] height) {
        int n;
        if (null == height || (n = height.length) <= 2) {
            return 0;
        }
        int result = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                result += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - height[top]);
            }
            stack.push(i);
        }
        return result;
    }

}