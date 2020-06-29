package question0209_minimum_size_subarray_sum;

/**
 * 暴力破解法。
 *
 * 时间复杂度是 O(n ^ 2)，其中 n 为数组 nums 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：175ms，击败9.64%。消耗内存：39.9MB，击败6.67%。
 */
public class Solution1 {
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < i + result && j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    result = Math.min(result, j - i + 1);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}