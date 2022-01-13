package question0050_powx_n;

public class Solution2 {

  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }
    long nl = n;
    if (nl < 0) {
      nl = -nl;
    }
    double result = 1.0;
    while (nl > 0) {
      if ((nl & 1) == 1) {
        result = result * x;
      }
      x *= x;
      nl /= 2;
    }
    return n < 0 ? 1 / result : result;
  }

}