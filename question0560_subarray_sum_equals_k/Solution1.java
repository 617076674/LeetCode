package question0560_subarray_sum_equals_k;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(n)
 *
 * 执行用时：759ms，击败5.03%。消耗内存：42.1MB，击败7.69%。
 */
public class Solution1 {
    public int subarraySum(int[] nums, int k) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return 0;
        }
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((i == 0 && sum[j] == k) || (i != 0 && sum[j] - sum[i - 1] == k)) {
                    result++;
                }
            }
        }
        return result;
    }
}