package question0209_minimum_size_subarray_sum;

/**
 * 滑动窗口法。
 *
 * 时间复杂度是 O(n)，其中 n 为数组 nums 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：175ms，击败9.64%。消耗内存：39.9MB，击败6.67%。
 */
public class Solution2 {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE, left = 0, right = -1, sum = 0;
        while (right + 1 < n) {
             right++;
             sum += nums[right];
            while (sum < s && right + 1 < n) {
                right++;
                sum += nums[right];
            }
            while (sum - nums[left] >= s && left + 1 <= right) {
                sum -= nums[left];
                left++;
            }
            result = Math.min(result, right - left + 1);
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}