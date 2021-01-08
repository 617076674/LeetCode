package question1646_get_maximum_in_generated_array;

public class Solution {

    public int getMaximumGenerated(int n) {
        if (n <= 1) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 1) {
                nums[i] = nums[i >> 1] + nums[(i >> 1) + 1];
            } else {
                nums[i] = nums[i >> 1];
            }
            result = Math.max(result, nums[i]);
        }
        return result;
    }

}