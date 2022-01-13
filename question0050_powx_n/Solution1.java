package question0050_powx_n;

/**
 * 递归实现。
 *
 * 时间复杂度和空间复杂度均是O(logn)。
 *
 * 执行用时：1ms，击败99.95%。消耗内存：33.4MB，击败75.61%。
 */
public class Solution1 {
  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n > 0) {
      double tmp = myPow(x, n / 2);
      return (n & 1) == 0 ? tmp * tmp : tmp * tmp * x;
    }
    double tmp = myPow(x, n / 2);
    return (n & 1) == 0 ? tmp * tmp : tmp * tmp / x;
  }
}