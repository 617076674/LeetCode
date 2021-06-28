package question0829_consecutive_numbers_sum;

public class Solution {

  public int consecutiveNumbersSum(int N) {
    // 2N = k(2x + k + 1) => k <= (2N) ^ 0.5
    int result = 0;
      for (int k = 1; k * k <= 2 * N; ++k) {
          if (2 * N % k == 0) {
              int y = 2 * N / k - k - 1;
              if (y % 2 == 0 && y >= 0) {
                  result++;
              }
          }
      }
    return result;
  }

}