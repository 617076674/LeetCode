package question2054_two_best_non_overlapping_events;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 动态规划。
 */
public class Solution {

  public int maxTwoEvents(int[][] events) {
    int n = events.length;
    // 根据结束时间排序
    Arrays.sort(events, Comparator.comparingInt(e -> e[1]));
    /*
     f[i] 表示 0 ~ i 范围内选一个的最大价值,
          很明显 f[i] = max(f[i-1], events[i][2])
     g[i] 表示 0 ~ i 范围内选两个的最大价值
          使用二分找到 结束时间 小于 当前开始时间 的最大下标j，
          g[i] = max(g[i-1], f[j] + events[i][2])
    */
    int[] f = new int[n], g = new int[n];
    for (int i = 0; i < n; ++i) {
      int left = 0, right = i - 1;
      while (left <= right) {
        int mid = left + ((right - left) >> 1);
        if (events[mid][1] >= events[i][0]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      f[i] = events[i][2];
      if (right > -1) {
        g[i] = f[right] + events[i][2];
      }
      if (i > 0) {
        f[i] = Math.max(f[i], f[i - 1]);
        g[i] = Math.max(g[i], g[i - 1]);
      }
    }
    return Math.max(f[n - 1], g[n - 1]);
  }

}