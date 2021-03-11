package question0503_next_greater_element_ii;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution2 {

    public int[] nextGreaterElements(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        fillResult(nums, result, stack);
        fillResult(nums, result, stack);
        return result;
    }

    private static void fillResult(int[] nums, int[] result, LinkedList<Integer> stack) {
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
    }

}