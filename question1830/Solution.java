package question1830;

public class Solution {

  private static final int MOD = 1000000007;

  public int makeStringSorted(String s) {
    int[] map = new int[26];
    for (int i = 0; i < s.length(); i++) {
      map[s.charAt(i) - 'a']++;
    }
    long[] fac = new long[s.length() + 1]; // i!阶乘
    long[] inv = new long[s.length() + 1]; // i!的乘法逆元
    fac[0] = inv[0] = 1;
    for (int i = 1; i <= s.length(); i++) {
      fac[i] = fac[i - 1] * i % MOD;
      inv[i] = quickMul(fac[i], MOD - 2);
    }
    long result = 0;
    for (int i = 0; i < s.length(); i++) {
      char cur = s.charAt(i);
      // 枚举之前状态i位置的字母
      for (int j = ((cur - 'a') - 1); j >= 0; j--) {
        if (map[j] == 0) {
          continue;
        }
        map[j]--; // 临时变换
        //计算组合数
        long bottomInv = 1;
        for (int count : map) {
          bottomInv = bottomInv * inv[count] % MOD;
        }
        long c = fac[s.length() - 1 - i] * bottomInv % MOD;
        result = (result + c) % MOD;
        map[j]++; // 复原
      }
      //进入下一个状态
      map[cur - 'a']--;
    }
    result = result % MOD;
    return (int) result;
  }

  private long quickMul(long x, long y) {
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