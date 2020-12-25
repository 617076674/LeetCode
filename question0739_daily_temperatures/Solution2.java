package question0739_daily_temperatures;

import java.util.LinkedList;

/**
 * 单调栈。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为数组 T 的长度。
 *
 * 执行用时：23ms，击败65.00%。消耗内存：47.5MB，击败6.45%。
 */
public class Solution2 {

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

}