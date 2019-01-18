package question154;

public class Solution2 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int result = Integer.MAX_VALUE;
        while (left < right) {
            if (right - left == 1) {
                return Math.min(result, Math.min(nums[left], nums[right]));
            }
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[right]) {
                return Math.min(result, nums[left]);
            } else if (nums[left] == nums[right]) {
                result = Math.min(result, nums[left]);
                left++;
                right--;
            } else {
                if (nums[left] <= nums[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        return Math.min(result, nums[left]);
    }
}
