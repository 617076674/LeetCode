package question1739;

public class Solution {

  public int minimumBoxes(int n) {
    int left = 1, right = n;
    while (left < right) {
      int mid = left + ((right - left) >> 1);
      if (check(mid, n)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private static boolean check(long bottom, int n) {
    int edge = (int) Math.sqrt(bottom * 2);
    while ((edge + 1) * edge / 2 > bottom) {
      edge--;
    }
    long extra = bottom - edge * (edge + 1) / 2;
    long[] count = new long[edge];
    for (int i = 0; i < edge; i++) {
      count[i] = edge - i;
    }
    for (int i = 0; i < extra; i++) {
      count[i]++;
    }
    long total = 0L, sufSum = 0L;
    for (int i = edge - 1; i >= 0; i--) {
      sufSum += count[i];
      total += sufSum;
    }
    return total >= n;
  }

}