package question0053;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 3)，其中n是数组的长度。空间复杂度是O(1)。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution1 {
    public int maxSubArray(int[] nums) {
        int n = nums.length, result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                result = Math.max(result, sum);
            }
        }
        return result;
    }
}
