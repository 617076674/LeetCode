package question1969_minimum_non_zero_product_of_the_array_elements;

public class Solution {

  private static final int MOD = 1000000007;

  public int minNonZeroProduct(int p) {
    long last = (1L << p) - 1;
    return (int) (pow(last - 1, (last - 1) / 2) * (last % MOD) % MOD);
  }

  private static long pow(long num, long exp) {
    if (exp == 0) {
      return 1;
    }
    if (exp == 1) {
      return num % MOD;
    }
    long half = pow(num, exp / 2);
    if ((exp & 1) == 0) {
      return half % MOD * half % MOD;
    }
    return half % MOD * half % MOD * (num % MOD) % MOD;
  }

}