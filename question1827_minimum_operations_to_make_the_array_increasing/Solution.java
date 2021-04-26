package question1827_minimum_operations_to_make_the_array_increasing;

public class Solution {

    public int minOperations(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1] + 1) {
                result += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return result;
    }

}