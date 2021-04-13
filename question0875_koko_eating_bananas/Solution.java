package question0875_koko_eating_bananas;

public class Solution {

  public int minEatingSpeed(int[] piles, int h) {
    int left = 1, right = 1;
    for (int pile : piles) {
      right = Math.max(right, pile);
    }
    while (left < right) {
      if (left + 1 == right) {
        if (canEatAll(piles, h, left)) {
          return left;
        }
        return right;
      }
      int mid = left + ((right - left) >> 1);
      if (canEatAll(piles, h, mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private static boolean canEatAll(int[] piles, int h, int k) {
    int result = 0;
    for (int pile : piles) {
      result += pile / k;
      if (pile % k != 0) {
        result++;
      }
    }
    return result <= h;
  }

}