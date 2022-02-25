package question2167;

public class Solution {

  public int minimumTime(String s) {
    // left[i] 表示将字符串 s [0, i - 1] 范围内的部分全部移除需要的最少花费
    int[] left = new int[s.length() + 1];
    for (int i = 1; i < left.length; i++) {
      if (s.charAt(i - 1) == '0') {
        left[i] = left[i - 1];
      } else {
        left[i] = Math.min(left[i - 1] + 2, i);
      }
    }
    // right[i] 表示将字符串 s [i, s.length() - 1] 范围内的部分全部移除需要的最少花费
    int[] right = new int[s.length() + 1];
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        right[i] = right[i + 1];
      } else {
        right[i] = Math.min(right[i + 1] + 2, s.length() - i);
      }
    }
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < s.length(); i++) {
      // [0, i] 范围内的部分从左侧移除，[i + 1, s.length() - 1] 范围内的部分从右侧移除
      result = Math.min(result, left[i + 1] + right[i + 1]);
    }
    return result;
  }

}