package question0718_maximum_length_of_repeated_subarray;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

  private static final int MOD = 1000000007;

  private static final int BASE = 113;

  public int findLength(int[] A, int[] B) {
    int left = 0, right = Math.min(A.length, B.length);
    while (left < right) {
      if (left + 1 == right) {
        if (check(A, B, right)) {
          return right;
        }
        return left;
      }
      int mid = left + ((right - left) >> 1);
      if (check(A, B, mid)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  private static boolean check(int[] A, int[] B, int len) {
    Set<Long> setA = new HashSet<>();
    long hash = 0;
    for (int i = 0; i < len; i++) {
      hash = (hash * BASE + A[i]) % MOD;
    }
    setA.add(hash);
    long temp = quickMul(BASE, len - 1);
    for (int i = len; i < A.length; i++) {
      hash = ((hash - A[i - len] * temp % MOD + MOD) % MOD * BASE + A[i]) % MOD;
      setA.add(hash);
    }
    hash = 0;
    for (int i = 0; i < len; i++) {
      hash = (hash * BASE + B[i]) % MOD;
    }
    if (setA.contains(hash)) {
      return true;
    }
    for (int i = len; i < B.length; i++) {
      hash = ((hash - B[i - len] * temp % MOD + MOD) % MOD * BASE + B[i]) % MOD;
      if (setA.contains(hash)) {
        return true;
      }
    }
    return false;
  }

  private static long quickMul(long x, long y) {
    long result = 1, cur = x;
    while (y > 0) {
      if ((y & 1) == 1) {
        result = result * cur % MOD;
      }
      cur = cur * cur % MOD;
      y >>= 1;
    }
    return result;
  }

}
