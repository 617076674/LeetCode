package question044_wildcard_matching;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[x, y]:字符串s中[0, x - 1]范围内的字符串能否匹配字符串p中[0, y - 1]范围内的字符串
 *
 * 状态转移：
 * （1）如果p.charAt(y - 1) == '?'或者p.charAt(y - 1) == s.charAt(x - 1), dp[x, y] = dp[x - 1, y - 1]。
 * （2）如果p.charAt(y - 1) == '*'，dp[x, y] = dp[x, y - 1] || dp[x - 1, y - 1] || dp[x - 2, y - 1] || ... || dp[0, y - 1]。
 *
 * 时间复杂度和空间复杂度均是O(ns * np)，其中ns为字符串s的长度，np为字符串p的长度。
 *
 * 执行用时：80ms，击败9.89%。消耗内存：48.7MB，击败47.04%。
 */
public class Solution2 {
    public boolean isMatch(String s, String p) {
        int ns = s.length(), np = p.length();
        boolean[][] dp = new boolean[ns + 1][np + 1];
        dp[0][0] = true;
        for (int i = 1; i < np + 1; i++) {
            dp[0][i] = true;
            for (int j = 0; j <= i - 1; j++) {
                if (p.charAt(j) != '*') {
                    dp[0][i] = false;
                }
            }
        }
        for (int i = 1; i < ns + 1; i++) {
            for (int j = 1; j < np + 1; j++) {
                if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    for (int k = 0; k <= i; k++) {
                        if (dp[i][j]) {
                            break;
                        }
                        dp[i][j] = dp[i][j] || dp[k][j - 1];
                    }
                }
            }
        }
        return dp[ns][np];
    }
}