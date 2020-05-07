package question0072_edit_distance;

/**
 * 状态压缩。
 *
 * 时间复杂度是O(m * n)，其中m为word1字符串的长度，n为word2字符串的长度。空间复杂度是O(min(m, n))。
 *
 * 执行用时：7ms，击败61.29%。消耗内存：39.7MB，击败5.00%。
 */
public class Solution2 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (n > m) {
            return minDistance(word2, word1);
        }
        int[][] dp = new int[2][n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j == 0) {
                    dp[i % 2][j] = i;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i % 2][j] = dp[1 - i % 2][j - 1];
                    } else {
                        dp[i % 2][j] = Math.min(dp[1 - i % 2][j - 1], Math.min(dp[1 - i % 2][j], dp[i % 2][j - 1])) + 1;
                    }
                }
            }
        }
        return dp[m % 2][n];
    }
}