package question2226;

public class Solution {

  public int maximumCandies(int[] candies, long k) {
    long sum = 0;
    for (int candy : candies) {
      sum += candy;
    }
    long left = 0, right = 10000000L;
    while (left <= right) {
      long mid = (left + right) / 2;
      if (check(candies, k, mid, sum)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    // [right, left]
    if (check(candies, k, left, sum)) {
      return (int) left;
    }
    return (int) right;
  }

  private static boolean check(int[] candies, long k, long turn, long sum) {
    if (turn == 0L) {
      return true;
    }
    if (k * turn > sum) {
      return false;
    }
    long cnt = 0L;
    for (int curCandy : candies) {
      cnt += curCandy / turn;
      if (cnt >= k) {
        return true;
      }
    }
    return false;
  }

}