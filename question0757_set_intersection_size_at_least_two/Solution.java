package question0757_set_intersection_size_at_least_two;

import java.util.Arrays;

/**
 * 贪心算法。
 */
public class Solution {

  public int intersectionSizeTwo(int[][] intervals) {
    Arrays.sort(intervals, (a, b) ->
        a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
    int[] todo = new int[intervals.length];
    Arrays.fill(todo, 2);
    int result = 0, t = intervals.length;
    while (--t >= 0) {
      int s = intervals[t][0];
      int m = todo[t];
      for (int p = s; p < s + m; ++p) {
        for (int i = 0; i <= t; ++i) {
          if (todo[i] > 0 && p <= intervals[i][1]) {
            todo[i]--;
          }
        }
        result++;
      }
    }
    return result;
  }

}