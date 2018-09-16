package question034;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82584821
 */
public class Solution {
	
	public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = floor(nums, target);
        result[1] = ceil(nums, target);
        return result;
    }
	
	private int floor(int[] nums, int target) {
		int left = -1;
		int right = nums.length - 1;
		while(left < right) {
			int mid = left + (right - left + 1) / 2;
			if(target <= nums[mid]) {
				right = mid - 1;
			}else {
				left = mid;
			}
		}
		if(left + 1 < nums.length && nums[left + 1] == target) {
			return left + 1;
		}else {
			return -1;
		}
	}
	
	private int ceil(int[] nums, int target) {
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
		if(right - 1 >= 0 && nums[right - 1] == target) {
			return right - 1;
		}else {
			return -1;
		}
	}
}
