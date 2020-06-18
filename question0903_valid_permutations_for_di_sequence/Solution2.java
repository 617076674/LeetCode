package question0903_valid_permutations_for_di_sequence;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示对于第 i 个数，剩余的数中有 j 个数是比前一个数要小的，这种情况下可以形成的组合数种数。
 *
 * 初始化条件：
 * dp[n + 1][j] = 1。
 *
 * 状态转移方程：
 * 如果 S.charAt(i - 1) == 'D'，dp[i][j] = sum(dp[i + 1][k]), k ∈ [0, j)。
 *
 * 如果 S.charAt(i - 1) == 'I'，dp[i][j] = sum(dp[i + 1][k]), k ∈ [j, n - i + 1)。
 *
 * 时间复杂度是 O(n ^ 3)，其中 n 为字符串 S 的长度。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：74ms，击败51.30%。消耗内存：39.3MB，击败100.00%。
 */
public class Solution2 {
    public int numPermsDISequence(String S) {
        int n = S.length(), MOD = 1000000007;
        int[][] dp = new int[n + 2][n + 1];
        dp[n + 1][0] = 1;
        for (int i = n; i > 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (S.charAt(i - 1) == 'D') {
                    for (int k = 0; k < j; k++) {
                        dp[i][j] += dp[i + 1][k];
                        dp[i][j] %= MOD;
                    }
                } else if (S.charAt(i - 1) == 'I') {
                    for (int k = j; k < n - i + 1; k++) {
                        dp[i][j] += dp[i + 1][k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        int result = 0;
        for (int j = 0; j < n + 1; j++) {
            result += dp[1][j];
            result %= MOD;
        }
        return result;
    }
}