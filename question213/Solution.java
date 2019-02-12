package question213;

public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return nums[0];
        }
        //sum[i]：考虑偷取[0, i]范围内的房子
        //1.先考虑偷取[0, n - 2]的房子
        int[] sum = new int[n - 1];
        sum[0] = nums[0];
        for (int i = 1; i < n - 1; i++) {
            sum[i] = 0;
            for (int j = 0; j <= i; j++) {
                if(j >= 2) {
                    sum[i] = Math.max(sum[i], sum[j - 2] + nums[j]);
                }else {
                    sum[i] = Math.max(sum[i], nums[j]);
                }
            }
        }
        int result1 = sum[n - 2];
        //2.再考虑偷取[1, n - 1]的房子
        int[] sum2 = new int[n];
        sum2[1] = nums[1];
        for (int i = 2; i < n; i++) {
            sum2[i] = 0;
            for (int j = 1; j <= i; j++) {
                if(j >= 3) {
                    sum2[i] = Math.max(sum2[i], sum2[j - 2] + nums[j]);
                }else {
                    sum2[i] = Math.max(sum2[i], nums[j]);
                }
            }
        }
        int result2 = sum2[n - 1];
        return Math.max(result1, result2);
    }
}