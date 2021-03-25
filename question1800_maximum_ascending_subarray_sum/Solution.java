package question1800_maximum_ascending_subarray_sum;

public class Solution {
    
    public int maxAscendingSum(int[] nums) {
        int result = 0, tempResult = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                tempResult += nums[i];
            } else {
                tempResult = nums[i];
            }
            result = Math.max(result, tempResult);
        }
        return result;
    }
    
}