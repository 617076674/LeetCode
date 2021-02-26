package lcci1716_the_masseuse;

/**
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 */
public class Solution {
    public int massage(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int dp1 = nums[0], dp2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int tmp = dp2;
            dp2 = Math.max(nums[i] + dp1, dp2);
            dp1 = tmp;
        }
        return dp2;
    }
}