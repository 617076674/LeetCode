package question1680_concatenation_of_consecutive_binary_numbers;

public class Solution2 {

  private static final int MOD = 1000000007;

  public int concatenatedBinary(int n) {
    long result = 0, shift = 0;
    for (int i = 1; i <= n; i++) {
      if ((i & (i - 1)) == 0) {
        shift++;
      }
      result = ((result << shift) + i) % MOD;
    }
    return (int) result;
  }

}
