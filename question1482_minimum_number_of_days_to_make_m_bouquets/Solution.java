package question1482_minimum_number_of_days_to_make_m_bouquets;

/**
 * 二分查找法。
 */
public class Solution {

  public int minDays(int[] bloomDay, int m, int k) {
    int left = 1, right = 1;
    for (int day : bloomDay) {
      right = Math.max(right, day);
    }
    while (left < right) {
      if (left + 1 == right) {
        if (check(bloomDay, left, m, k)) {
          return left;
        }
        if (check(bloomDay, right, m, k)) {
          return right;
        }
        return -1;
      }
      int mid = left + ((right - left) >> 1);
      if (check(bloomDay, mid, m, k)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return check(bloomDay, left, m, k) ? left : -1;
  }

  private boolean check(int[] bloomDay, int now, int m, int k) {
    boolean[] opened = new boolean[bloomDay.length];
    for (int i = 0; i < bloomDay.length; i++) {
      if (now >= bloomDay[i]) {
        opened[i] = true;
      }
    }
    int result = 0;
    for (int i = 0; i < opened.length; i++) {
      if (opened[i]) {
        int j = i;
        while (j + 1 < opened.length && j - i + 1 < k && opened[j + 1]) {
          j++;
        }
        if (j - i + 1 == k) {
          result++;
        }
        i = j;
      }
    }
    return result >= m;
  }

}