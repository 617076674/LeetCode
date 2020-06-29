package question0215_kth_largest_element_in_an_array;

/**
 * 快排。
 *
 * 时间复杂度是 O(n)。空间复杂度是 O(logn)。
 *
 * 执行用时：3ms，击败70.82%。消耗内存：39.7MB，击败6.12%。
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private int findKthLargest(int[] nums, int left, int right, int k) {
        if (left == right && k == 1) {
            return nums[left];
        }
        swap(nums, left, (int) (left + 1 + Math.random() * (right - left)));
        // [left + 1, lessThan], [lessThan + 1, i), [greaterThan, right]
        int lessThan = left, i = left + 1, greaterThan = right + 1;
        while (i < greaterThan) {
            if (nums[i] == nums[left]) {
                i++;
            } else if (nums[i] < nums[left]) {
                swap(nums, i, --greaterThan);
            } else {
                swap(nums, i++, ++lessThan);
            }
        }
        // [left + 1, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
        swap(nums, lessThan--, left);
        // [left, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
        if (k <= lessThan - left + 1) {
            return findKthLargest(nums, left, lessThan, k);
        } else if (k >= greaterThan - left + 1) {
            return findKthLargest(nums, greaterThan, right, k - greaterThan + left);
        }
        return nums[lessThan + 1];
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}