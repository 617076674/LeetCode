package question0416_partition_equal_subset_sum;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示能否用 [i, n - 1] 范围内的元素组成和 j，其中 n 为 nums 数组的长度。
 *
 * 初始化条件：
 * dp[n - 1][nums[n - 1]] = true。
 *
 * 状态转移方程：
 * dp[i][j] = dp[i + 1][j] || (dp[i + 1][j - nums[i]], j >= nums[i])。
 *
 * 时间复杂度是 O(n * target)，其中 target 为数组 nums 中数字和的一半。空间复杂度是 O(n * target)。
 */
public class Solution {
  public boolean canPartition(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 == 1) {
      return false;
    }
    int target = sum / 2;
    boolean[][] dp = new boolean[n][target + 1];
    if (nums[n - 1] > target) {
      return false;
    }
    dp[n - 1][nums[n - 1]] = true;
    for (int i = n - 2; i >= 0; i--) {
      for (int j = 0; j < target + 1; j++) {
        dp[i][j] = dp[i + 1][j];
        if (nums[i] <= j) {
          dp[i][j] |= dp[i + 1][j - nums[i]];
        }
      }
    }
    return dp[0][target];
  }
}