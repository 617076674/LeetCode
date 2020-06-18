package question0903_valid_permutations_for_di_sequence;

/**
 * 记忆化搜索。
 *
 * 状态定义：
 * dp[i][j] 表示对于第 i 个数，剩余的数中有 j 个数是比前一个数要小的，这种情况下可以形成的组合数种数。
 *
 * 初始化条件：
 * dp[n + 1][j] = 1。
 *
 * 状态转移方程：
 * 如果 S.charAt(i - 1) == 'D'，dp[i][j] = sum(dp[i + 1][k]), k ∈ [0, j)。
 * 如果 S.charAt(i - 1) == 'I'，dp[i][j] = sum(dp[i + 1][k]), k ∈ [j, n - i + 1)。
 *
 * 时间复杂度是 O(n ^ 3)，其中 n 为字符串 S 的长度。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：74ms，击败51.30%。消耗内存：39.3MB，击败100.00%。
 */
public class Solution1 {
    private static final int MOD = 1000000007;

    private int[][] memo;

    public int numPermsDISequence(String S) {
        memo = new int[S.length() + 2][S.length() + 1];
        int result = 0;
        for (int i = 0; i <= S.length(); i++) {
            result += numPermsDISequence(S, 1, i);
            result %= MOD;
        }
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }
        return result;
    }

    private int numPermsDISequence(String S, int index, int lessThanPre) {
        if (memo[index][lessThanPre] != 0) {
            return memo[index][lessThanPre];
        }
        if (index == S.length() + 1) {
            memo[index][lessThanPre] = 1;
            return 1;
        }
        int greaterThanPre = S.length() - index - lessThanPre + 1, result = 0;
        if (S.charAt(index - 1) == 'D') {
            for (int i = 0; i < lessThanPre; i++) {
                // 总共有 lessThanPre 个数是比 pre 要小的，假定这些数是 [0, 1, 2, ... lessThanPre - 1]
                // 总共有 greaterThanPre 个数是比 pre 要大的 [0, 1, 2, ... greaterThanPre - 1]
                // dp[i][j] = dp[i + 1][0] + dp[i + 1][1] + ... + dp[i + 1][j - 1]
                // dp[i][j + 1] = dp[i + 1][0] + dp[i + 1][1] + ... + dp[i + 1][j] = dp[i][j] + dp[i + 1][j]
                // dp[i][j] = dp[i][j + 1] - dp[i + 1][j]
                result += numPermsDISequence(S, index + 1, i);
                result %= MOD;
            }
        } else if (S.charAt(index - 1) == 'I') {
            for (int i = 0; i < greaterThanPre; i++) {
                // 总共有 lessThanPre 个数是比 pre 要小的，假定这些数是 [0, 1, 2, ... lessThanPre - 1]
                // 总共有 greaterThanPre 个数是比 pre 要大的 [0, 1, 2, ... greaterThanPre - 1]
                // dp[i][j] = dp[i + 1][j] + dp[i + 1][j + 1] + ... + dp[i + 1][n - i]
                // dp[i][j + 1] = dp[i + 1][j + 1] + dp[i + 1][j + 2] + ... + dp[i + 1][n - i]
                // dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
                result += numPermsDISequence(S, index + 1, lessThanPre + i);
                result %= MOD;
            }
        }
        memo[index][lessThanPre] = result;
        return result;
    }

    public static void main(String[] args) {
        String S = "DID";
        System.out.println(new Solution3().numPermsDISequence(S));
    }
}