package question0910_smallest_range_ii;

import java.util.Arrays;

public class Solution {

  public int smallestRangeII(int[] A, int K) {
    int N = A.length;
    Arrays.sort(A);
    int result = A[N - 1] - A[0];

    for (int i = 0; i < A.length - 1; ++i) {
      int high = Math.max(A[N - 1] - K, A[i] + K);
      int low = Math.min(A[0] + K, A[i + 1] - K);
      result = Math.min(result, high - low);
    }
    return result;
  }

}