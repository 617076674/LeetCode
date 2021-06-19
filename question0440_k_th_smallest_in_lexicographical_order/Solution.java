package question0440_k_th_smallest_in_lexicographical_order;

public class Solution {

  public int findKthNumber(int n, int k) {
    long p = 1, prefix = 1;
    while (p < k) {
      long count = getCount(prefix, n);
      if (p + count > k) {
        prefix *= 10;
        p++;
      } else if (p + count <= k) {
        prefix++;
        p += count;
      }
    }
    return (int) prefix;
  }

  private static long getCount(long prefix, long n) {
    long cur = prefix, next = prefix + 1, result = 0;
    while (cur <= n) {
      result += Math.min(n + 1, next) - cur;
      cur *= 10;
      next *= 10;
    }
    return result;
  }

}