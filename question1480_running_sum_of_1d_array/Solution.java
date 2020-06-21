package question1480_running_sum_of_1d_array;

/**
 * 时间复杂度是O(n)，其中 n 为数组 nums 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：40MB，击败100.00%。
 */
public class Solution {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = nums[i];
            } else {
                result[i] = nums[i] + result[i - 1];
            }
        }
        return result;
    }
}