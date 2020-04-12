package question1150_check_if_a_number_is_majority_element_in_a_sorted_array;

/**
 * 二分查找法。
 *
 * 时间复杂度是O(logn)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.3MB，击败6.67%。
 */
public class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int left = floor(nums, target);
        if (left == -1) {
            return false;
        }
        int right = ceil(nums, target);
        if (right - left + 1 > (nums.length >> 1)) {
            return true;
        }
        return false;
    }

    private int floor(int[] nums, int target) {
        int left = -1, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (left + 1 < nums.length && nums[left + 1] == target) {
            return left + 1;
        }
        return -1;
    }

    private int ceil(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left - 1 >= 0 && nums[left - 1] == target) {
            return left - 1;
        }
        return -1;
    }
}