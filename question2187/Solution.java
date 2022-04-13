package question2187;

public class Solution {

  public long minimumTime(int[] time, int totalTrips) {
    long left = 1, right = 1000_000_000_000_001L;
    while (left <= right) {
      long mid = (left + right) / 2;
      if (check(time, totalTrips, mid)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (check(time, totalTrips, right)) {
      return right;
    }
    return left;
  }

  private static boolean check(int[] time, int totalTrips, long t) {
    long result = 0;
    for (int tempTime : time) {
      result += t / tempTime;
      if (result >= totalTrips) {
        return true;
      }
    }
    return false;
  }

}