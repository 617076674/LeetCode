package question0053;

/**
 * 动态规划。
 *
 * 状态定义：
 * f(i)----------以第i个数字结尾的子数组的最大和。
 *
 * 状态转移：
 * 如果i == 0或f(i - 1) <= 0，f(i) = nums[i]。
 * 否则，f(i) = f(i - 1) + nums[i]。
 *
 * 时间复杂度是O(n)，其中n是nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败97.99%。消耗内存：39.2MB，击败75.98%。
 */
public class Solution4 {
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
