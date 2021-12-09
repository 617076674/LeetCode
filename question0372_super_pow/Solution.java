package question0372_super_pow;

public class Solution {

  private static final int MOD = 1337;

  public int superPow(int a, int[] b) {
    return superPowHelper(a, b, b.length - 1);
  }

  private static int superPowHelper(int a, int[] b, int index) {
    int result = quickMul(a, b[index]);
    if (index > 0) {
      result *= quickMul(superPowHelper(a, b, index - 1), 10);
    }
    return result % MOD;
  }

  private static int quickMul(int a, int b) {
    if (a == 1 || b == 0) {
      return 1;
    }
    int half = quickMul(a, b >> 1);
    half %= MOD;
    a %= MOD;
    if ((b & 1) == 1) {
      return (((half * half) % MOD) * a) % MOD;
    }
    return (half * half) % MOD;
  }

}