package question0403_frog_jump;

import java.util.HashMap;
import java.util.Map;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是O((n ^ 2) * log(n))，其中n为stones数组的长度。空间复杂度均是O(n ^ 2)。
 *
 * 执行用时：64ms，击败79.78%。消耗内存：71.7MB，击败15.22%。
 */
public class Solution {

  private Boolean[][] dp;

  private int n;

  private Map<Integer, Integer> stone2Index = new HashMap<>();

  public boolean canCross(int[] stones) {
    if (stones[1] - stones[0] != 1) {
      return false;
    }
    for (int i = 0; i < stones.length; i++) {
      stone2Index.put(stones[i], i);
    }
    n = stones.length;
    dp = new Boolean[n][n];
    return canCross(stones, 1, 1);
  }

  /**
   * 目前在stones数组的now索引处，上一步跳跃了preStep个单位，判断能否到达stones数组中的最后一个位置。
   */
  private boolean canCross(int[] stones, int now, int preStep) {
    if (now >= n) {
      return false;
    }
    if (now == n - 1) {
      return true;
    }
    if (dp[now][preStep] != null) {
      return dp[now][preStep];
    }
    for (int step = preStep - 1; step <= preStep + 1; step++) {
      if (step == 0) {
        continue;
      }
      Integer index = stone2Index.get(stones[now] + step);
      if (index != null && canCross(stones, index, step)) {
        dp[now][preStep] = true;
        return true;
      }
    }
    dp[now][preStep] = false;
    return false;
  }

}