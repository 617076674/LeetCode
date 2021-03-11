package question1552_magnetic_force_between_two_balls;

import java.util.Arrays;

/**
 * 二分查找法。
 */
public class Solution {

  public int maxDistance(int[] position, int m) {
    Arrays.sort(position);
    int left = 1, right = position[position.length - 1] - position[0], result = -1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (check(mid, position, m)) {
        result = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return result;
  }

  private static boolean check(int gap, int[] position, int m) {
    int pre = position[0], cnt = 1;
    for (int i = 1; i < position.length; i++) {
      if (position[i] - pre >= gap) {
        pre = position[i];
        cnt++;
      }
    }
    return cnt >= m;
  }

}