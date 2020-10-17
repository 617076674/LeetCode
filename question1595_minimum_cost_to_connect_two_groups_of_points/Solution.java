package question1595_minimum_cost_to_connect_two_groups_of_points;

import java.util.Arrays;
import java.util.List;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][s] 表示第一组中 [0, i - 1] 范围内的元素和第二组相连接，第二组的连接状态为 s，最小的连接成本。
 *
 * 初始化条件：
 * dp[0][0] = 0。
 *
 * 状态转移方程：
 * dp[i][s | (1 << j)] = min(dp[i][s], dp[i - 1][s]) + cost[i - 1][j]。
 *
 * 时间复杂度和空间复杂度是 O(size1 * size2 * 2 ^ size2)。空间复杂度是 O(size1 * 2 ^ size2)。
 *
 * 执行用时：30ms，击败87.35%。消耗内存：38.4MB，击败61.48%。
 */
public class Solution {

  public int connectTwoGroups(List<List<Integer>> cost) {
    int size1 = cost.size();
    int size2 = cost.get(0).size();
    int[][] dp = new int[size1 + 1][1 << size2];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
    }
    dp[0][0] = 0;
    for (int i = 0; i < size1; i++) {
      for (int j = 0; j < size2; j++) {
        for (int s = 0; s < (1 << size2); s++) {
          dp[i + 1][s | (1 << j)] = Math.min(dp[i + 1][s | (1 << j)], Math.min(dp[i + 1][s],
              dp[i][s]) + cost.get(i).get(j));
        }
      }
    }
    return dp[size1][(1 << size2) - 1];
  }

}