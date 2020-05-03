package question0053_maximum_subarray;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i]：以第i个数字结尾的子数组的最大和。
 *
 * 状态转移：
 * （1）如果i == 0或dp[i - 1] <= 0，dp[i] = nums[i]。
 * （2）否则，dp[i] = dp[i - 1] + nums[i]。
 *
 * 由于dp[i]仅依赖于dp[i - 1]，故可以进行状态压缩，用一个变量来代替dp数组。
 *
 * 时间复杂度是O(n)，其中n是nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败97.99%。消耗内存：39.2MB，击败75.98%。
 */
public class Solution3 {
    public int maxSubArray(int[] nums) {
        int n = nums.length, result = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            result = Math.max(result, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }
}