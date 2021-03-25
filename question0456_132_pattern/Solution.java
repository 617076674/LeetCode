package question0456_132_pattern;

import java.util.Stack;

/**
 * 单调栈。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为nums数组的长度。
 *
 * 执行用时：8ms，击败95.87%。消耗内存：42.4MB，击败5.45%。
 */
public class Solution {

    public boolean find132pattern(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        for (int j = n - 1; j >= 0; j--) {  //从后往前遍历nums数组中的元素
            if (nums[j] > min[j]) { //找到了ai = min[j]和aj = nums[j]，现在需要在[j + 1, n - 1]范围内寻找ak使得ai < ak < aj
                //如果栈顶元素小于等于min[j]的，将栈顶元素出栈，这样就保证了ak > ai
                //那么已弹出栈的元素是否可能会被漏过呢？
                //不会的，因为我们从后往前遍历nums数组中的元素，min数组的值会越来越大，那些已经出栈的元素更加不可能大于当前的min[j]，即a[i]
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {   //判断栈顶元素是否满足ak < aj
                    return true;
                }
                stack.push(nums[j]);    //保证了栈中的元素肯定是在[j + 1, n - 1]范围内的，即我们在栈中寻找ak
            }
        }
        return false;
    }

}