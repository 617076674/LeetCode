package question1201_ugly_number_iii;

public class Solution {

  public int nthUglyNumber(int n, int a, int b, int c) {
    long ab = lcm(a, b), ac = lcm(a, c), bc = lcm(b, c), abc = lcm(ab, c);      // a,b,c三个数的最大公倍数
    long left = Math.min(a, Math.min(b, c)), right = 2000000000L;
    while (left < right) {
      long mid = left + ((right - left) >> 1);
      // num为[1...mid]中的丑数个数（容斥原理）
      long num = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
      if (num >= n) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return (int) left;
  }

  private static long gcd(long x, long y) {
    return y == 0 ? x : gcd(y, x % y);
  }

  private static long lcm(long x, long y) {
    return x * y / gcd(x, y);
  }

}