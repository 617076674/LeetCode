package question0516_longest_palindromic_subsequence;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j]表示字符串s中[i, j]范围内的子串中的最长回文序列长度。
 *
 * 初始化条件：
 * 当i == j时，dp[i][j] = 1。
 *
 * 状态转移方程：
 * （1）如果s.charAt(i) == s.charAt(j)，那么dp[i][j] = dp[i + 1][j - 1] + 2。
 * （2）如果s.charAt(i) != s.charAt(j)，那么dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为字符串s的长度。
 *
 * 执行用时：61ms，击败28.97%。消耗内存：54.3MB，击败6.00%。
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int gap = -1; gap >= 1 - n; gap--) {
            for (int i = 0; i < n + gap; i++) {
                int j = i - gap;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}