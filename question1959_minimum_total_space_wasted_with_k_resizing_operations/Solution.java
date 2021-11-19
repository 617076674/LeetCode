package question1959_minimum_total_space_wasted_with_k_resizing_operations;

/**
 * 动态规划。
 *
 * 给定数组 nums 以及整数 k，需要把数组完整地分成 k + 1 段连续的子数组，每一段的权值是 [这一段的最大值乘以这一段
 * 的长度再减去这一段的元素和]
 */
public class Solution {

  private int[][] weight;

  private Integer[][] memo;

  public int minSpaceWastedKResizing(int[] nums, int k) {
    weight = new int[nums.length][nums.length];
    int[] sums = new int[nums.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
    }
    int[][] maxes = getDP(nums);
    for (int gap = -1; gap >= 1 - nums.length; gap--) {
      for (int i = 0; i < nums.length + gap; i++) {
        int j = i - gap;
        weight[i][j] = (j - i + 1) * rmq(maxes, i, j) - (sums[j + 1] - sums[i]);
      }
    }
    memo = new Integer[nums.length][k + 2];
    return minSpaceWastedKResizing(nums, 0, k + 1);
  }

  private static int rmq(int[][] dp, int left, int right) {
    int k = (int) (Math.log(right - left + 1) / Math.log(2));
    return Math.max(dp[left][k], dp[right - (1 << k) + 1][k]);
  }

  private static int[][] getDP(int[] height) {
    int[][] dp = new int[height.length][10];
    for (int i = 0; i < height.length; i++) {
      dp[i][0] = height[i];
    }
    for (int j = 1; (1 << j) <= height.length; j++) {
      for (int i = 0; i + (1 << j) - 1 < height.length; i++) {
        dp[i][j] = Math.max(dp[i][j - 1], dp[i + (1 << (j - 1))][j - 1]);
      }
    }
    return dp;
  }

  /**
   * 将 nums 数组中 [index, nums.length - 1] 范围内的元素划分为 segments 段，得到的权值最小值。
   */
  private int minSpaceWastedKResizing(int[] nums, int index, int segments) {
    if (index == nums.length) {
      return 0;
    }
    if (segments == 1) {
      return weight[index][nums.length - 1];
    }
    if (null != memo[index][segments]) {
      return memo[index][segments];
    }
    int result = Integer.MAX_VALUE / 2;
    for (int i = index; i < nums.length; i++) {
      // [index, i] 为一段
      result = Math.min(result, weight[index][i] + minSpaceWastedKResizing(nums, i + 1, segments - 1));
    }
    memo[index][segments] = result;
    return result;
  }

}