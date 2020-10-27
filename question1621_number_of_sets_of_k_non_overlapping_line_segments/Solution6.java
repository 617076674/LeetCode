package question1621_number_of_sets_of_k_non_overlapping_line_segments;

import java.math.BigDecimal;

public class Solution6 {

  private static final int MOD = 1000000007;

  public int numberOfSets(int n, int k) {
    return combination(n + k - 1, 2 * k).divideAndRemainder(BigDecimal.valueOf(MOD))[1].intValue();
  }

  private BigDecimal combination(int n, int k) {
    return multiplyResult(k + 1, n).divide(multiplyResult(1, n - k));
  }

  private BigDecimal multiplyResult(int left, int right) {
    BigDecimal result = BigDecimal.valueOf(1);
    for (int i = left; i <= right; i++) {
      result = result.multiply(BigDecimal.valueOf(i));
    }
    return result;
  }

}