package question035;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82585110
 */
public class Solution1 {

	public int searchInsert(int[] nums, int target) {
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
        return left + 1;  
    }
}
