package question0995_minimum_number_of_k_consecutive_bit_flips;

public class Solution2 {

  public int minKBitFlips(int[] A, int K) {
    int result = 0, sumDiff = 0;
    for (int i = 0; i < A.length; i++) {
      if (i >= K && A[i - K] > 1) {
        sumDiff--;
        A[i - K] -= 2;
      }
      if ((A[i] + sumDiff) % 2 == 0) {
        if (i + K > A.length) {
          return -1;
        }
        result++;
        sumDiff++;
        A[i] += 2;
      }
    }
    return result;
  }

}