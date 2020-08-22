package question1259_handshakes_that_dont_cross;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是 O(num_people ^ 2)。空间复杂度是 O(num_people)。
 *
 * 执行用时：51ms，击败66.67%。消耗内存：36.3MB，击败100.00%。
 */
public class Solution1 {
    private long[] memo;

    private static final int MOD = 1000000007;

    public int numberOfWays(int num_people) {
        memo = new long[num_people + 1];
        return (int) numberOfWaysHelper(num_people);
    }

    private long numberOfWaysHelper(int n) {
        if (n == 0) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        int result = 0;
        for (int i = 0; i < n; i += 2) {
            result += (numberOfWaysHelper(i) * numberOfWaysHelper(n - i - 2)) % MOD;
            result %= MOD;
        }
        memo[n] = result;
        return result;
    }
}