package question0918_maximum_sum_circular_subarray;

public class Solution1 {

  public int maxSubarraySumCircular(int[] A) {
    int sum1 = A[0], sum = A[0], result1 = A[0];
    for (int i = 1; i < A.length; i++) {
      sum1 = Math.max(sum1, 0);
      sum1 += A[i];
      result1 = Math.max(result1, sum1);
      sum += A[i];
    }
    int result2 = 0, sum2 = 0;
    for (int i = 1; i < A.length - 1; i++) {
      sum2 = Math.min(sum2, 0);
      sum2 += A[i];
      result2 = Math.min(result2, sum2);
    }
    return Math.max(result1, sum - result2);
  }

}