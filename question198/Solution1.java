package question198;

public class Solution1 {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        //sum[i]：考虑偷取[0, i]范围内的房子
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < sum.length; i++) {
            for (int j = 0; j <= i; j++) {
                if(j >= 2) {
                    sum[i] = Math.max(sum[i], sum[j - 2] + nums[j]);
                }else {
                    sum[i] = Math.max(sum[i], nums[j]);
                }
            }
        }
        return sum[nums.length - 1];
    }
}

