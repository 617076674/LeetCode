package question1622_fancy_sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * 乘法逆元。
 *
 * https://leetcode-cn.com/problems/fancy-sequence/solution/qi-miao-xu-lie-by-zerotrac2/
 */
public class Fancy2 {

  private static final int MOD = 1000000007;

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

  // 乘法逆元
  private long inv(long x) {
    return quickMul(x, MOD - 2);
  }

  private List<Long> valList = new ArrayList<>();

  private List<Long> aList = new ArrayList<>();

  private List<Long> bList = new ArrayList<>();

  public Fancy2() {
    aList.add(1L);
    bList.add(0L);
  }

  public void append(int val) {
    valList.add((long) val);
    aList.add(aList.get(aList.size() - 1));
    bList.add(bList.get(bList.size() - 1));
  }

  public void addAll(int inc) {
    bList.set(bList.size() - 1, (bList.get(bList.size() - 1) + inc) % MOD);
  }

  public void multAll(int m) {
    aList.set(aList.size() - 1, aList.get(aList.size() - 1) * (long) m % MOD);
    bList.set(bList.size() - 1, bList.get(bList.size() - 1) * (long) m % MOD);
  }

  public int getIndex(int idx) {
    if (idx >= valList.size()) {
      return -1;
    }
    long a = inv(aList.get(idx)) * aList.get(aList.size() - 1) % MOD;
    long b = (bList.get(bList.size() - 1) - bList.get(idx) * a % MOD + MOD) % MOD;
    return (int) ((a * valList.get(idx) % MOD + b) % MOD);
  }

}