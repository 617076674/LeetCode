package question053;

public class Solution4 {

	public int maxSubArray(int[] nums) {
		int n = nums.length;
		int result = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			result = Math.max(result, sum);
			if(sum < 0) {
				sum = 0;
			}
		}
		return result;
    }
}
