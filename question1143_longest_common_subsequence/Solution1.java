package question1143_longest_common_subsequence;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示 text1 中 [0, i - 1]内的子串和 text2 中 [0, j - 1]内的子串的最长公共子序列的长度。
 *
 * 初始化条件：
 * （1）当i == 0时，dp[0][j] = 0。
 * （2）当j == 0时，dp[i][0] = 0。
 *
 * 时间复杂度和空间复杂度是O(m * n)，其中m为字符串text1的长度，n为字符串text2的长度。
 *
 * 执行用时：13ms，击败69.20%。消耗内存：43.7MB，击败8.33%。
 */
public class Solution1 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}