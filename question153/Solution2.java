package question153;

public class Solution2 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (right - left == 1) {
                return Math.min(nums[left], nums[right]);
            }
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[right]) {
                return nums[left];
            } else {
                if (nums[left] < nums[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        return nums[left];
    }
}
