package question1621_number_of_sets_of_k_non_overlapping_line_segments;

public class Solution4 {

    private static final int MOD = 1000000007;

    private long[][] memo;

    public int numberOfSets(int n, int k) {
        memo =  new long[n + 1][k + 1];
        return (int) numberOfSetsHelper(n, k);
    }

    private long numberOfSetsHelper(int n, int k) {
        if (k >= n) {
            return 0;
        }
        if (k == n - 1) {
            return 1;
        }
        if (k == 1) {
            return n * (n - 1) / 2;
        }
        if (memo[n][k] != 0) {
            return memo[n][k];
        }
        memo[n][k] = (numberOfSetsHelper(n - 1, k) * 2) % MOD;
        memo[n][k] = (memo[n][k] + numberOfSetsHelper(n - 1, k - 1)) % MOD;
        memo[n][k] = (memo[n][k] - numberOfSetsHelper(n - 2, k) + MOD) % MOD;
        return memo[n][k];
    }

}