package question0891_sum_of_subsequence_widths;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i] 以 nums[i] 为最大值的所有子序列的宽度和。
 *
 * 状态转移：
 * dp[i] = dp[i - 1] + (nums[i] - nums[i - 1]) * (2 ^ (i - 1))
 * + dp[i - 1] + (nums[i] - nums[i - 1]) * (2 ^ (i - 1) - 1)
 * = 2 * dp[i - 1] + (nums[i] - nums[i - 1]) * (2 ^ i - 1)
 */
public class Solution {

  private static int MOD = 1000000007;

  public int sumSubseqWidths(int[] nums) {
    Arrays.sort(nums);
    long[] dp = new long[nums.length];
    long temp = 1;
    long result = 0;
    for (int i = 1; i < dp.length; i++) {
      temp <<= 1;
      temp %= MOD;
      dp[i] = dp[i - 1] * 2 + (nums[i] - nums[i - 1]) * (temp - 1);
      dp[i] %= MOD;
      result += dp[i];
      result %= MOD;
    }
    return (int) result;
  }

}