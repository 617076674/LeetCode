package question026;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82378663
 */
public class Solution {
	
	public int removeDuplicates(int[] nums) {
		int n = nums.length;
		if(n == 0) {
			return 0;
		}
		int index = 1;
		for (int i = 1; i < n; i++) {
			if(nums[i] == nums[i - 1]) {
				continue;
			}
			nums[index] = nums[i];
			index++;
		}
		return index;
	}
}
