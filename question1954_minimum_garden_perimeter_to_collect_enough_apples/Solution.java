package question1954_minimum_garden_perimeter_to_collect_enough_apples;

public class Solution {

  public long minimumPerimeter(long neededApples) {
    long left = 1, right = 100000;
    while (left < right) {
      if (left + 1 == right) {
        if (check(left, neededApples)) {
          return left << 3;
        }
        return right << 3;
      }
      long mid = left + ((right - left) >> 1);
      if (check(mid, neededApples)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left << 3;
  }

  private boolean check(long length, long needApples) {
    long row = length * (length + 1);
    long sum = row * 2 * (length * 2 + 1);
    return sum >= needApples;
  }

}