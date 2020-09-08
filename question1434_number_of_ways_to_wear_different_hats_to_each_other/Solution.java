package question1434_number_of_ways_to_wear_different_hats_to_each_other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 不是人选帽子，而是帽子去选人。
 *
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示当前状态是 i，正在分配第 j 顶帽子，有几种分法。
 *
 * 初始化条件：
 * dp[(1 << n) - 1][j] = 1，其中 n 为人数。
 * dp[i][j] = 0, j > 40。
 *
 * 状态转移方程：
 * dp[i][j] = dp[i][j + 1] + dp[nextI][j + 1]，nextI 即分配第 j 定帽子可能造成的状态转移结果。
 *
 * 时间复杂度是 O(40 * n * 2 ^ n)。空间复杂度是 O(40 * 2 ^ n)。
 *
 * 执行用时：36ms，击败34.65%。消耗内存：39.1MB，击败90.70%。
 */
public class Solution {
  private static final int MOD = 1000000007;

  private Set[] hat2Person = new HashSet[41];

  private int n;

  private int[][] memo;

  public int numberWays(List<List<Integer>> hats) {
    n = hats.size();
    for (int i = 0; i < n; i++) {
      for (int hat : hats.get(i)) {
        if (hat2Person[hat] == null) {
          hat2Person[hat] = new HashSet();
        }
        hat2Person[hat].add(i);
      }
    }
    memo = new int[1 << n][41];
    for (int i = 0; i < memo.length; i++) {
      Arrays.fill(memo[i], -1);
    }
    return numberWays(0, 1);
  }

  /**
   * 当前状态是 status，分配第 hatIndex 顶帽子，有几种分法
   */
  private int numberWays(int status, int hatIndex) {
    if (status == (1 << n) - 1) {
      return 1;
    }
    if (hatIndex > 40) {
      return 0;
    }
    if (memo[status][hatIndex] != -1) {
      return memo[status][hatIndex];
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      if ((status & (1 << i)) == 0 && hat2Person[hatIndex] != null && hat2Person[hatIndex].contains(i)) {
        result += numberWays(status | (1 << i), hatIndex + 1);
        result %= MOD;
      }
    }
    result += numberWays(status, hatIndex + 1);
    memo[status][hatIndex] = result % MOD;
    return memo[status][hatIndex];
  }
}