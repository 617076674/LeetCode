package question1911_maximum_alternating_subsequence_sum;

public class Solution {

    public long maxAlternatingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        long[][] dp = new long[nums.length][2];
        long max0 = nums[0] - nums[1], max1 = Math.max(nums[0], nums[1]);
        dp[0][1] = nums[0];
        dp[1][0] = nums[0] - nums[1];
        dp[1][1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i][0] = max1 - nums[i];
            dp[i][1] = Math.max(nums[i], max0 + nums[i]);
            max0 = Math.max(max0, dp[i][0]);
            max1 = Math.max(max1, dp[i][1]);
        }
        return Math.max(max0, max1);
    }

}