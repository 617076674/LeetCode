package question0053;

/**
 * 暴力破解法的优化。
 *
 * 时间复杂度是O(n ^ 2)，其中n是nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：182ms，击败5.11%。消耗内存：43.1MB，击败41.80%。
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        int n = nums.length, result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                result = Math.max(result, sum);
            }
        }
        return result;
    }
}
