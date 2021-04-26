package question1288_remove_covered_intervals;

import java.util.Arrays;

public class Solution {

  public int removeCoveredIntervals(int[][] intervals) {
    Arrays.sort(intervals, (interval1, interval2) -> {
      if (interval1[0] == interval2[0]) {
        return interval2[1] - interval1[1];
      }
      return interval1[0] - interval2[0];
    });
    int result = intervals.length, maxRight = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][1] <= maxRight) {
        result--;
      }
      if (intervals[i][0] != intervals[i - 1][0]) {
        maxRight = Math.max(maxRight, intervals[i][1]);
      }
    }
    return result;
  }

}