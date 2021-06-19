package question1877_minimize_maximum_pair_sum_in_array;

import java.util.Arrays;

public class Solution {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            result = Math.max(result, nums[i] + nums[nums.length - i - 1]);
        }
        return result;
    }

}