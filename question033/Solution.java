package question033;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82584549
 */
public class Solution {
	
	public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
        	int mid = left + (right - left) / 2;
        	if(target > nums[left]) {
        		if(target > nums[mid]) {
        			if(nums[mid] >= nums[left]) {
        				left = mid + 1;
        			}else {
        				right = mid - 1;
        			}
        		}else if(target == nums[mid]) {
        			return mid;
        		}else {
        			right = mid - 1;
        		}
        	}else if(target == nums[left]) {
        		return left;
        	}else {
        		if(target > nums[mid]) {
        			left = mid + 1;
        		}else if(target == nums[mid]) {
        			return mid;
        		}else {
        			if(nums[mid] >= nums[left]) {
        				left = mid + 1;
        			}else {
        				right = mid - 1;
        			}
        		}
        	}
        }
        return -1;
    }
}
