package question016;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82177199
 */
public class Solution1 {
	
	public int threeSumClosest(int[] nums, int target) {
		int n = nums.length;
		int diff = Integer.MAX_VALUE;
		int result = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				for(int k = j + 1; k < n; k++) {
					if(Math.abs(nums[i] + nums[j] + nums[k] - target) < diff) {
						diff = Math.abs(nums[i] + nums[j] + nums[k] - target);
						result = nums[i] + nums[j] + nums[k];
					}
				}
			}
		}
		return result;
	}
}
