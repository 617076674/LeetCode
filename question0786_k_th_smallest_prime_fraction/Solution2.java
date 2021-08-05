package question0786_k_th_smallest_prime_fraction;

public class Solution2 {
  public int[] kthSmallestPrimeFraction(int[] primes, int k) {
    double lo = 0, hi = 1;
    int[] ans = new int[] {0, 1};
    while (hi - lo > 1e-9) {
      double mi = lo + (hi - lo) / 2.0;
      int[] res = under(mi, primes);
      if (res[0] < k) {
        lo = mi;
      } else {
        ans[0] = res[1];
        ans[1] = res[2];
        hi = mi;
      }
    }
    return ans;
  }

  public int[] under(double x, int[] primes) {
    // Returns {count, numerator, denominator}
    int numer = 0, denom = 1, count = 0, i = -1;
    for (int j = 1; j < primes.length; j++) {
      // For each j, find the largest i so that primes[i] / primes[j] < x
      // It has to be at least as big as the previous i, so reuse it ("two pointer")
      while (primes[i + 1] < primes[j] * x) {
        i++;
      }
      // There are i+1 fractions: (primes[0], primes[j]),
      // (primes[1], primes[j]), ..., (primes[i], primes[j])
      count += i + 1;
      if (i >= 0 && numer * primes[j] < denom * primes[i]) {
        numer = primes[i];
        denom = primes[j];
      }
    }
    return new int[] {count, numer, denom};
  }

}