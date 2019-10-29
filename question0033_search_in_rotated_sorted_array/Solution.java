package question0033_search_in_rotated_sorted_array;

/**
 * 二分法。
 *
 * 时间复杂度是O(logn)，其中n是nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败90.20%。消耗内存：35.4MB，击败88.68%。
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target > nums[left]) {
                if (target > nums[mid]) {
                    if (nums[mid] >= nums[left]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else if (target == nums[mid]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (target == nums[left]) {
                return left;
            } else {
                if (target > nums[mid]) {
                    left = mid + 1;
                } else if (target == nums[mid]) {
                    return mid;
                } else {
                    if (nums[mid] >= nums[left]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}