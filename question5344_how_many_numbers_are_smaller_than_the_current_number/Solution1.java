package question5344_how_many_numbers_are_smaller_than_the_current_number;

import java.util.Arrays;

/**
 * 排序后使用floor()函数二分查找。
 *
 * 时间复杂度是O(nlogn)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：4ms，击败100.00%。消耗内存：41.9MB，击败100.00%。
 */
public class Solution1 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] result = new int[n], copyNums = new int[n];
        for (int i = 0; i < n; i++) {
            copyNums[i] = nums[i];
        }
        Arrays.sort(copyNums);
        for (int i = 0; i < n; i++) {
            result[i] = floor(copyNums, nums[i]) + 1;
        }
        return result;
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
        return left;
    }
}