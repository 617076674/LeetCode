package question198;

public class Solution2 {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int[] sum = new int[nums.length + 1];
        sum[1] = nums[nums.length - 1];
        sum[2] = Math.max(sum[1], nums[nums.length - 2]);
        for (int i = 3; i <= nums.length; i++) {
            for (int j = 1; j <= i; j++) {
                if(i - j - 1 > 0) {
                    sum[i] = Math.max(nums[nums.length - i + j - 1] + sum[i - j - 1], sum[i]);
                }else {
                    sum[i] = Math.max(nums[nums.length - i + j - 1], sum[i]);
                }
            }
        }
        return sum[nums.length];
    }
}

