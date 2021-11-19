package question2055_plates_between_candles;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分法。
 *
 * O(nlogm)，其中 n 为 queries 的长度，m 为字符串 s 中 '|' 的个数。
 */
public class Solution1 {

  public int[] platesBetweenCandles(String s, int[][] queries) {
    List<Integer> list = new ArrayList<>(s.length());
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '|') {
        list.add(i);
      }
    }
    // [2, 5, 7]
    // sums[i] 表示 [0, i] 范围内有多少个 *
    int[] sums = new int[list.size()];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + list.get(i) - list.get(i - 1) - 1;
    }
    int[] result = new int[queries.length];
    int index = 0;
    for (int[] query : queries) {
      int left = ceil(list, query[0]), right = floor(list, query[1]);
      if (left >= 0 && right >= 0) {
        result[index++] = Math.max(0, sums[right] - sums[left]);
      } else {
        result[index++] = 0;
      }
    }
    return result;
  }

  private static int ceil(List<Integer> list, int target) {
    if (list.isEmpty()) {
      return -1;
    }
    int left = 0, right = list.size() - 1;
    while (left < right) {
      int mid = left + ((right - left) >> 1);
      if (target == list.get(mid)) {
        return mid;
      }
      if (target > list.get(mid)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    if (list.get(left) >= target || left + 1 >= list.size()) {
      return left;
    }
    return left + 1;
  }

  private static int floor(List<Integer> list, int target) {
    if (list.isEmpty()) {
      return -1;
    }
    int left = 0, right = list.size() - 1;
    while (left < right) {
      int mid = left + ((right - left) >> 1);
      if (target == list.get(mid)) {
        return mid;
      }
      if (target > list.get(mid)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    if (list.get(left) <= target || left - 1 < 0) {
      return left;
    }
    return left - 1;
  }

}