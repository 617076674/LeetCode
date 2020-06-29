package question0209_minimum_size_subarray_sum;

/**
 * 二分查找法。
 *
 * 时间复杂度是 O(nlogn)，其中 n 为数组 nums 的长度。空间复杂度是 O(n)。
 *
 * 执行用时：8ms，击败19.28%。消耗内存：39.7MB，击败6.67%。
 */
public class Solution3 {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int j = floor(sum, s + (i == 0 ? 0 : sum[i - 1]));
            if (j != nums.length) {
                result = Math.min(result, j - i + 1);
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private int floor(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left + 1 < nums.length && nums[left + 1] == target) {
            return left + 1;
        }
        return left;
    }
}