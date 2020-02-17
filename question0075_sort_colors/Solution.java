package question0075_sort_colors;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 *
 * 快排。
 *
 * 时间复杂度是O(n)，其中n是数组nums的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：41.8MB，击败5.08%。
 */
public class Solution {
    public void sortColors(int[] nums) {
        //[0, lessThan] restore 0; [lessThan + 1, i) restore 1; [greaterThan, nums.length - 1] restore 2
        int lessThan = -1, greaterThan = nums.length, i = 0;
        while (i < greaterThan) {
            if (nums[i] == 0) {
                swap(nums, i, lessThan + 1);
                lessThan++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, greaterThan - 1);
                greaterThan--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}