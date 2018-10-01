package question055;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82810039
 */
public class Solution {

	public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) {
        	return true;
        }
		int index = 0;
		if(nums[index] == 0) {
			return false;
		}
		while(index < n - 1) {
			int[] lengths = new int[nums[index]];
			if(index + nums[index] >= n - 1) {
				return true;
			}
			for (int i = index + 1; i <= index + nums[index]; i++) {
				lengths[i - index - 1] = i + nums[i];
			}
        	int max = 0;
        	for (int i = 0; i < lengths.length; i++) {
				if(lengths[i] > lengths[max]) {
					max = i;
				}
			}
        	index = max + index + 1;
        	if(nums[index] == 0) {
        		return false;
        	}
		}
		return true;
    }
}
