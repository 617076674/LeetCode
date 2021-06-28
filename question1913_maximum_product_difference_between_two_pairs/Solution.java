package question1913_maximum_product_difference_between_two_pairs;

import java.util.Arrays;

public class Solution {
    
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
    }
    
}