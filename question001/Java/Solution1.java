package question001;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81501389
 */
public class Solution1 {
	
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
        return result;
    }
}
