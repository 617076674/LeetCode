package question053;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82796047
 */
public class Solution2 {

	public int maxSubArray(int[] nums) {
		int n = nums.length;
		int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
        	int sum = 0;
			for (int j = i; j < n; j++) {
				sum += nums[j];
				result = Math.max(result, sum);
			}
		}
        return result;
    }
}
