package question0992_subarrays_with_k_different_integers;

public class Solution {

  public int subarraysWithKDistinct(int[] A, int K) {
    return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
  }

  private int atMostKDistinct(int[] A, int K) {
    int[] window = new int[A.length + 1];
    int left = 0, right = -1, result = 0, diff = 0;
    while (right + 1 < A.length) {
      right++;
      if (window[A[right]] == 0) {
        diff++;
      }
      window[A[right]]++;
      while (diff > K) {
        window[A[left]]--;
        if (window[A[left]] == 0) {
          diff--;
        }
        left++;
      }
      result += right - left + 1;
    }
    return result;
  }

}