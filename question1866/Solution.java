package question1866;

public class Solution {

  private static final int MOD = 1000000007;

  private Integer[][] memo = new Integer[1001][1001];

  public int rearrangeSticks(int n, int k) {
    if (n == 0) {
      if (k == 0) {
        return 1;
      }
      return 0;
    }
    if (k == 0) {
      return 0;
    }
    if (n == k) {
      return 1;
    }
    if (memo[n][k] != null) {
      return memo[n][k];
    }
    memo[n][k] = (int) (rearrangeSticks(n - 1, k - 1) + 1L *(n - 1) * rearrangeSticks(n - 1, k) % MOD) % MOD;
    return memo[n][k];
  }

}