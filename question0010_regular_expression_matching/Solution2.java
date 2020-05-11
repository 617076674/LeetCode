package question0010_regular_expression_matching;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示字符串 s 中 [0, i - 1] 范围内的字符串能否匹配字符串 p 中 [0, j - 1] 范围内的字符串。
 *
 * 初始化条件：
 * （1）dp[0][0] = true。
 * （2）当 i != 0 时，dp[i][0] = false。
 * （3）当 j 是奇数时，dp[0][j] = false。
 * （4）当 j 是偶数时，如果字符串 p 中 [0, j - 1] 范围内的子串不满足 a*b*c* 的形式，则 dp[0][j] = false，否则 dp[0][j] = true。
 *
 * 状态转移方程：
 * （1）如果 p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1), dp[i][j] = dp[i - 1][j - 1]。
 * （2）如果p.charAt(j - 1) == '*'，
 *      a.如果s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'，dp[i][j] = dp[i - 1][j] || dp[i][j - 2]
 *      b.如果s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.'，dp[i][j] = dp[i][j - 2]。
 *
 * 时间复杂度和空间复杂度均是O(ns * np)，其中ns是字符串s的长度，np是字符串p的长度。
 *
 * 执行用时：8ms，击败87.43%。消耗内存：35.8MB，击败89.46%。
 */
public class Solution2 {
    public boolean isMatch(String s, String p) {
        int ns = s.length() + 1, np = p.length() + 1;
        boolean[][] dp = new boolean[ns][np];
        dp[0][0] = true;
        for (int i = 1; i < np; i++) {
            if (((i - 1) & 1) == 1) {
                if (p.charAt(i - 1) != '*') {
                    break;
                }
                dp[0][i] = true;
            }
        }
        for (int i = 1; i < ns; i++) {
            for (int j = 1; j < np; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    }
                }
            }
        }
        return dp[ns - 1][np - 1];
    }
}