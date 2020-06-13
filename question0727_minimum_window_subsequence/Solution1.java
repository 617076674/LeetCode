package question0727_minimum_window_subsequence;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示对于以字符 S.charAt(i - 1) 结尾的子串能够包含以字符 T.charAt(j - 1) 结尾的子串的最小的长度。
 *
 * 初始化条件：
 * 当 j != 0 时，dp[0][j] = INF
 *
 * 状态转移方程：
 * 如果 S.charAt(i - 1) == T.charAt(j - 1)，则有 dp[i][j] = dp[i - 1][j - 1] + 1。否则，dp[i][j] = dp[i - 1][j] + 1。
 *
 * 时间复杂度和空间复杂度均是 O(m * n)，其中 m 为字符串 S 的长度，n 为字符串 T 的长度。
 *
 * 执行用时：100ms，击败31.82%。消耗内存：50.5MB，击败100.00%。
 */
public class Solution1 {
    public String minWindow(String S, String T) {
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        int INF = S.length() + 1;
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = INF;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }
        String result = "";
        int minLen = INF;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][T.length()] < minLen) {
                minLen = dp[i][T.length()];
                result = S.substring(i - minLen, i);
            }
        }
        return minLen >= INF ? "" : result;
    }
}