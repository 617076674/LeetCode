package question162;

public class Solution2 {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }

    private int findPeakElement(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = left + (right - left) / 2;
        if (mid + 1 < nums.length) {
            if (mid - 1 >= 0) {
                if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                    return mid;
                } else if (nums[mid + 1] > nums[mid - 1]) {
                    return findPeakElement(nums, mid + 1, right);
                } else {
                    return findPeakElement(nums, left, mid - 1);
                }
            } else {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    return findPeakElement(nums, mid + 1, right);
                }
            }
        } else {
            if (nums[mid] > nums[mid - 1]) {
                return mid;
            } else {
                return findPeakElement(nums, left, mid - 1);
            }
        }
    }
}
