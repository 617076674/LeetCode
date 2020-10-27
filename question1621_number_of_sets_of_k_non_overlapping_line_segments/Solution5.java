package question1621_number_of_sets_of_k_non_overlapping_line_segments;

public class Solution5 {

  private static final int MOD = 1000000007;

  private long[][] memo;

  public int numberOfSets(int n, int k) {
    memo =  new long[n + k][k * 2 + 1];
    return (int) combination(n + k - 1, 2 * k);
  }

  private long combination(int n, int k) {
    if (n == k || k == 0) {
      return 1;
    }
    if (memo[n][k] != 0) {
      return memo[n][k];
    }
    memo[n][k] = (combination(n - 1, k) + combination(n - 1, k - 1)) % MOD;
    return memo[n][k];
  }

}