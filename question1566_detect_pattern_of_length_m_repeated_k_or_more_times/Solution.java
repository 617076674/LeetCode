package question1566_detect_pattern_of_length_m_repeated_k_or_more_times;

public class Solution {

  public boolean containsPattern(int[] arr, int m, int k) {
    for (int i = 0; i < arr.length - m * k + 1; i++) {
      int j = 1;
      for ( ; j < k; j++) {
        if (!compare(arr, i, i + m - 1, i + j * m, i + (j + 1) * m - 1)) {
          break;
        }
      }
      if (j == k) {
        return true;
      }
    }
    return false;
  }

  private boolean compare(int[] arr, int left1, int right1, int left2, int right2) {
    for (int i = left1; i <= right1; i++) {
      if (arr[i] != arr[left2 + i - left1]) {
        return false;
      }
    }
    return true;
  }

}