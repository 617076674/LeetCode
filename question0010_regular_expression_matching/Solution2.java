package question0010_regular_expression_matching;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * 动态规划。
 *
 * 状态定义：
 * dp[x, y]------字符串s中[0, x - 1]范围内的字符串能否匹配字符串p中[0, y - 1]范围内的字符串
 *
 * 初始条件：
 * dp[0, 0] = true。dp[x, 0] = false, x ∈[1, s.length()]。
 *
 * 状态转移：
 * （1）如果p.charAt(y) == '.'或p.charAt(y) == s.charAt(x), dp[x, y] = dp[x - 1, y - 1]。
 * （2）如果p.charAt(y) == '*'，
 *      a.如果s.charAt(x) == p.charAt(y - 1)或p.charAt(y - 1) == '.'，
 *          a-1：使用'*'号进行匹配——dp[x - 1, y]
 *          a-2：只使用'*'号前面的那个字符匹配，不使用'*'匹配——dp[x, y - 1]
 *          a-3：'*'号前面的那个字符在匹配的过程当中一个都不使用——dp[x, y - 2]
 *      dp[x, y] = dp[x - 1, y] || dp[x, y - 1] || dp[x, y - 2]
 *      b.如果s.charAt(x) != p.charAt(y - 1)且p.charAt(y - 1) != '.'
 *      *号前面的那个字符在匹配的过程当中一个都不使用，dp[x, y] = dp[x, y - 2]
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
        for (int i = 0; i < ns; i++) {
            for (int j = 1; j < np; j++) {
                if (i > 0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (i == 0 || (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.')) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                }
            }
        }
        return dp[ns - 1][np - 1];
    }
}