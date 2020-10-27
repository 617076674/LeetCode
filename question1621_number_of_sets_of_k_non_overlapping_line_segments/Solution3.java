package question1621_number_of_sets_of_k_non_overlapping_line_segments;

public class Solution3 {

  private static final int MOD = 1000000007;

  private long[][][] memo;

  public int numberOfSets(int n, int k) {
    memo =  new long[n + 1][k + 1][2];
    return (int) numberOfSetsHelper(n, k, 0);
  }

  private long numberOfSetsHelper(int n, int k, int selected) {
    if (k == 0) {
      return 1;
    }
    if (k > n) {
      return 0;
    }
    if (memo[n][k][selected] != 0) {
      return memo[n][k][selected];
    }
    if (selected == 0) {
      memo[n][k][selected] = numberOfSetsHelper(n - 1, k, selected) + numberOfSetsHelper(n - 1, k, 1);
    } else {
      memo[n][k][selected] = numberOfSetsHelper(n - 1, k, selected) + numberOfSetsHelper(n, k - 1, 0);
    }
    memo[n][k][selected] %= MOD;
    return memo[n][k][selected];
  }

}