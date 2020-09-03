package question1326_minimum_number_of_taps_to_open_to_water_a_garden;

import java.util.Arrays;

/**
 * 贪心算法：
 * 一开始我们在位置 n 处，能到达的最左侧是 furthest。
 *
 * 索引 i 从 n 遍历到 1 的过程中，每次都更新 furthest 的值，但只有在 i == now 时，才必须更新我们的位置，令 now == furthest。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：4ms，击败88.02%。消耗内存：39.7MB，击败92.67%。
 */
public class Solution2 {
  public int minTaps(int n, int[] ranges) {
    // lefts[i] 表示右边界为 i，左边界为 lefts[i] 的一个区间
    int[] lefts = new int[n + 1];
    Arrays.fill(lefts, n);
    for (int i = 0; i < n + 1; i++) {
      int left = Math.max(i - ranges[i], 0);
      int right = Math.min(i + ranges[i], n);
      lefts[right] = Math.min(lefts[right], left);
    }
    int result = 0, now = n, furthest = Integer.MAX_VALUE;
    for (int i = n; i > 0; i--) {
      furthest = Math.min(furthest, lefts[i]);
      if (i == now) {
        if (furthest >= i) {
          return -1;
        }
        now = furthest;
        result++;
      }
    }
    return result;
  }
}