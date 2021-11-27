package question1751;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  private Integer[][] memo;

  public int maxValue(int[][] events, int k) {
    Arrays.sort(events, Comparator.comparingInt(event -> event[1]));
    memo = new Integer[events.length][k + 1];
    return maxValueHelper(events, events.length - 1, k);
  }

  // 在 [0, index] 范围内选取 k 个 event
  private int maxValueHelper(int[][] events, int index, int k) {
    if (index < 0 || k == 0) {
      return 0;
    }
    if (null != memo[index][k]) {
      return memo[index][k];
    }
    memo[index][k] = Math.max(maxValueHelper(events, index - 1, k),
        events[index][2] + maxValueHelper(events,
            choose(events, 0, index - 1, events[index][0]), k - 1));
    return memo[index][k];
  }

  /**
   * 在 [i, j] 范围内选取一个尽可能大的 index，满足条件 events[index][1] < target
   */
  private int choose(int[][] events, int i, int j, int target) {
    int left = i, right = j;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (events[mid][1] == target) {
        right = mid - 1;
      } else if (events[mid][1] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (left >= i && left <= j && events[left][1] < target) {
      return left;
    }
    if (right >= i && right <= j && events[right][1] < target) {
      return right;
    }
    return -1;
  }


}