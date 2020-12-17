package question0327_count_of_range_sum;

/**
 * 暴力破解法。
 *
 * 时间复杂度是 O(n ^ 2)，其中 n 为数组 nums 的长度。空间复杂度是 O(n)。
 *
 * 执行用时：195ms，击败12.36%。消耗内存：38.5MB，击败91.69%。
 */
public class Solution1 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];   // sum[i] = nums[0] + ... + nums[i - 1]
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                // 求 nums[i] + ... + nums[j]
                long tmp = sum[j + 1] - sum[i];
                if (tmp >= lower && tmp <= upper) {
                    result++;
                }
            }
        }
        return result;
    }
}