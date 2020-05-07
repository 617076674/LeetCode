package question1143_longest_common_subsequence;

/**
 * 状态压缩。
 *
 * 时间复杂度是O(m * n)，其中m为字符串text1的长度，n为字符串text2的长度。空间复杂度是O(min(m, n))。
 *
 * 执行用时：16ms，击败27.43%。消耗内存：37.2MB，击败8.33%。
 */
public class Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (n > m) {
            return longestCommonSubsequence(text2, text1);
        }
        int[][] dp = new int[2][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i % 2][j] = dp[1 - i % 2][j - 1] + 1;
                } else {
                    dp[i % 2][j] = Math.max(dp[1 - i % 2][j], dp[i % 2][j - 1]);
                }
            }
        }
        return dp[m % 2][n];
    }
}