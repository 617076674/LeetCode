package lcp22_ccw6C7;

public class Solution {

  public int paintingPlan(int n, int k) {
    if (k == 0 || k == n * n) {
      return 1;
    }
    int result = 0;
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        if (i * n + j * n - i * j == k) {
          result += C(n, i) * C(n, j);
        }
      }
    }
    return result;

  }

  public int C(int n, int val) {
    if (val == 0 || val == n) {
      return 1;
    }
    return factorial(n) / factorial(val) / factorial(n - val);
  }

  public int factorial(int n) {
    int result = 1;
    for (int i = n; i > 0; i--) {
      result *= i;
    }
    return result;
  }

}