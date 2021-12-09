package question1994;

public class Solution {

  private int[] map = new int[31];

  private int[] mutex = new int[31];

  private static final int MOD = 1000000007;

  public int numberOfGoodSubsets(int[] nums) {
    for (int num : nums) {
      map[num]++;
    }
    map[4] = map[8] = map[9] = map[12] = map[16] = map[18] = map[20] = map[24] = map[25] = map[27] = map[28] = 0;

    for (int i = 2; i <= 30; i++) {
      for (int j = 2; j <= 30; j++) {
        if (i != j && gcd(i, j) > 1) {
          mutex[i] ^= (1 << j);
        }
      }
    }
    return (int) (numberOfGoodSubsetsHelper(2, 0) * quickMul(2, map[1]) % MOD);
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

  private long numberOfGoodSubsetsHelper(int num, int status) {
    if (num == 31) {
      return status == 0 ? 0 : 1;
    }
    // 不选择数字 num
    long result = numberOfGoodSubsetsHelper(num + 1, status);
    // 选择数字 num
    if (map[num] > 0 && (mutex[num] & status) == 0) {
      result += (map[num] * numberOfGoodSubsetsHelper(num + 1, status ^ (1 << num))) % MOD;
    }
    return result % MOD;
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

}