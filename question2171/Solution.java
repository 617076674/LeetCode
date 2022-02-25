package question2171;

import java.util.Arrays;

public class Solution {

  public long minimumRemoval(int[] beans) {
    Arrays.sort(beans);
    long[] sums = new long[beans.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + beans[i - 1];
    }
    long result = Long.MAX_VALUE;
    for (int i = -1; i < beans.length; i++) {
      if (i == -1) {
        // [0, n - 1] 的豆子全部取到只剩下 beans[0]
        result = Math.min(result, sums[sums.length - 1] - beans[0] * 1L * beans.length);
      } else if (i == beans.length - 1) {
        // [0, n - 1] 范围内的豆子全部取出
        result = Math.min(result, sums[sums.length - 1]);
      } else {
        // [0, i] 范围内的豆子全部取出，[i + 1, n - 1] 范围内的豆子取到只剩下 beans[i + 1]
        result = Math.min(result, sums[i + 1] + sums[sums.length - 1] - sums[i + 1] - beans[i + 1] * 1L * (beans.length - 1 - i));
      }
    }
    return result;
  }

}