package question1621_number_of_sets_of_k_non_overlapping_line_segments;

public class Solution1 {

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
        for (int i = 2; i <= n - k + 1; i++) {
            memo[n][k] += (i - 1) * numberOfSetsHelper(n - i + 1, k - 1);
            memo[n][k] %= MOD;
        }
        return memo[n][k];
    }

}