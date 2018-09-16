package question027;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82413748
 */
public class Solution {
	
	public static int removeElement(int[] nums, int val) {
		int index = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == val) {
				continue;
			}
			nums[index] = nums[i];
			index++;
		}
		return index;
	}
}
