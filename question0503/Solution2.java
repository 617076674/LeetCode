package question0503;

import java.util.Stack;

/**
 * @author qianyihui
 * @date 2019-08-10
 *
 * 单调栈。栈顶元素始终是[i + 1, 2 * n - 1]范围内比nums[i]大的最近值。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为nums数组的长度。
 *
 * 执行用时：83ms，击败29.24%。消耗内存：52.5MB，击败59.46%。
 */
public class Solution2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            result[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return result;
    }
}
