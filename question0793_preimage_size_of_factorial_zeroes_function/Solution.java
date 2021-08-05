package question0793_preimage_size_of_factorial_zeroes_function;

public class Solution {

  public int preimageSizeFZF(int k) {
    long x = helper(k);
    if (check(x) == k) {
      return 5;
    }
    return 0;
  }

  private long helper(long k) {
    long left = 0, right = 5 * k;
    while (left < right) {
      long mid = left + ((right - left) >> 1);
      if (check(mid) == k) {
        return mid;
      }
      if (check(mid) > k) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private int check(long x) {
    int result = 0;
    while (x > 0) {
      result += x / 5;
      x /= 5;
    }
    return result;
  }

}