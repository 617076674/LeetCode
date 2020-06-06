package lcci1617_contiguous_sequence;

/**
 * 时间复杂度是 O(n)，其中 n 为 nums 数组的长度。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败94.85%。消耗内存：39.8MB，击败100.00%。
 */
public class Solution1 {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            result = Math.max(result, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }
}