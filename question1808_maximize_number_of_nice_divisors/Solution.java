package question1808_maximize_number_of_nice_divisors;

public class Solution {

  private static final int MOD = 1000000007;

  public int maxNiceDivisors(int primeFactors) {
    return (int) maxNiceDivisorsHelper(primeFactors);
  }

  public long maxNiceDivisorsHelper(int primeFactors) {
    if (primeFactors <= 3) {
      return primeFactors;
    }
    if (primeFactors == 4) {
      return 4;
    }
    int num = primeFactors % 3;
    if (num == 0) {
      return pow(3, primeFactors / 3);
    }
    if (num == 1) {
      return (pow(3, primeFactors / 3 - 1) * 4) % MOD;
    }
    return (pow(3, primeFactors / 3 - 1) * 6) % MOD;
  }

  private static long pow(long base, int exp) {
    if (exp == 0) {
      return 1;
    }
    if (exp == 1) {
      return base;
    }
    long half = pow(base, exp / 2);
    if ((exp & 1) == 1) {
      return ((half * half % MOD) * base) % MOD;
    }
    return (half * half) % MOD;
  }

}