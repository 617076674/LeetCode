package question1547_minimum_cost_to_cut_a_stick;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示对于 cuts 数组中 [i, j] 范围内的切割点所需的最小切割成本。
 *
 * cuts 数组中 [i, j] 范围内的切割点所对应的木棍长度是确定的！！！，所以不是四维dp，而是二维dp。
 *
 * 时间复杂度是 O(m ^ 3)，其中 m 为 cuts 数组的长度。空间复杂度是 O(m ^ 2)。
 *
 * 执行用时：34ms，击败18.10%。消耗内存：38.7MB，击败23.06%。
 */
public class Solution {

  private int[][] memo;

  public int minCost(int n, int[] cuts) {
    Arrays.sort(cuts);
    memo = new int[cuts.length][cuts.length];
    for (int i = 0; i < memo.length; i++) {
      Arrays.fill(memo[i], Integer.MAX_VALUE);
    }
    return minCost(cuts, 0, cuts.length - 1, 0, n);
  }

  private int minCost(int[] cuts, int i, int j, int left, int right) {
    if (i > j) {
      return 0;
    }
    if (i == j) {
      return right - left;
    }
    if (memo[i][j] != Integer.MAX_VALUE) {
      return memo[i][j];
    }
    memo[i][j] = Integer.MAX_VALUE;
    for (int k = i; k <= j; k++) {
      memo[i][j] = Math.min(memo[i][j], right - left +
          minCost(cuts, i, k - 1, left, cuts[k]) + minCost(cuts, k + 1, j, cuts[k], right));
    }
    return memo[i][j];
  }

}