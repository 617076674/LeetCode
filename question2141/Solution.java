package question2141;

import java.util.Arrays;

public class Solution {

  public long maxRunTime(int n, int[] batteries) {
    Arrays.sort(batteries);
    long sum = 0L;
    for (int i = 0; i < batteries.length - n; i++) {
      sum += batteries[i];
    }
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i = batteries.length - n; i < batteries.length; i++) {
      min = Math.min(min, batteries[i]);
      max = Math.max(max, batteries[i]);
    }
    long left = min, right = max + sum / n;
    while (left <= right) {
      long mid = (left + right) / 2;
      if (check(n, batteries, mid) <= sum) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    if (check(n, batteries, left) <= sum) {
      return left;
    }
    return right;
  }

  private static long check(int n, int[] batteries, long target) {
    long result = 0L;
    for (int i = batteries.length - n; i < batteries.length; i++) {
      if (batteries[i] < target) {
        result += target - batteries[i];
      }
    }
    return result;
  }

}