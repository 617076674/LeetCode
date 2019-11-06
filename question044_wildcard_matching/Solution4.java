package question044_wildcard_matching;

/**
 * 将Solution3改写为动态规划。
 *
 * 状态定义：
 * dp[x, y]:字符串s中[0, x - 1]范围内的字符串能否匹配字符串p中[0, y - 1]范围内的字符串
 *
 * 状态转移：
 * （1）如果p.charAt(y - 1) == '?'或者p.charAt(y - 1) == s.charAt(x - 1), dp[x, y] = dp[x - 1, y - 1]。
 * （2）如果p.charAt(y - 1) == '*'，f(x, y) = f(x, y - 1) || f(x - 1, y)。
 *
 * 时间复杂度和空间复杂度均是O(ns * np)级别的，其中ns为字符串s的长度，np为字符串p的长度。
 *
 * 执行用时：18ms，击败64.19%。消耗内存：38MB，击败94.39%。
 */
public class Solution4 {
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
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[ns][np];
    }
}