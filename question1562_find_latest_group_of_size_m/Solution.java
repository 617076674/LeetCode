package question1562_find_latest_group_of_size_m;

import java.util.Arrays;

public class Solution {

  public int findLatestStep(int[] arr, int m) {
    int n = arr.length;
    int[][] endpoints = new int[n + 1][2];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(endpoints[i], -1);
    }
    int cnt = 0;
    int result = -1;
    for (int i = 0; i < n; i++) {
      int left = arr[i], right = arr[i];
      if (arr[i] > 1 && endpoints[arr[i] - 1][0] != -1) {
        left = endpoints[arr[i] - 1][0];
        int leftLength = endpoints[arr[i] - 1][1] - endpoints[arr[i] - 1][0] + 1;
        if (leftLength == m) {
          cnt--;
        }
      }
      if (arr[i] < n && endpoints[arr[i] + 1][1] != -1) {
        right = endpoints[arr[i] + 1][1];
        int rightLength = endpoints[arr[i] + 1][1] - endpoints[arr[i] + 1][0] + 1;
        if (rightLength == m) {
          cnt--;
        }
      }
      int length = right - left + 1;
      if (length == m) {
        cnt++;
      }
      if (cnt > 0) {
        result = i + 1;
      }
      endpoints[left][0] = endpoints[right][0] = left;
      endpoints[left][1] = endpoints[right][1] = right;
    }
    return result;
  }

}