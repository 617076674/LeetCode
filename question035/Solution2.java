package question035;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82585110
 */
public class Solution2 {

	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(target >= nums[mid]) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		if(left - 1 >= 0 && nums[left - 1] == target) {
			return left - 1;
		}else {
			return left;  
		}
	}
}
