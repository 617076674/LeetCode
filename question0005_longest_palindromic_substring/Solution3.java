package question0005_longest_palindromic_substring;

/**
 * 动态规划。
 *
 * 状态定义：
 *
 * dp[i][j]表示字符串s中[i, j]范围内的子串是否是回文串
 *
 * 状态转移：
 *
 * （1）当i == j时，[i, j]范围内只有一个字符，显然是回文串，dp[i][j] = true。
 *
 * （2）当(j - i) ∈ (0, 2]时，[i, j]范围内有2个字符或3个字符，不管是2个字符还是3个字符，
 * 此时[i, j]范围内的子串是回文串的条件是s.charAt(i) == s.charAt(j)。
 *
 * （3）当(j - i) > 2时，[i, j]范围内超出3个字符，
 * 此时[i, j]范围内的子串是回文串的条件是s.charAt(i) == s.charAt(j)且[i + 1, j - 1]范围内的子串是回文串。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为输入字符串s的长度。
 *
 * 执行用时：88ms，击败46.94%。消耗内存：50.9MB，击败20.54%。
 */
public class Solution3 {
    public String longestPalindrome(String s) {
        int n;
        if (null == s || (n = s.length()) < 2) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        String result = "";
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (1 > result.length()) {
                result = s.substring(i, i + 1);
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] || j - i <= 2)) {
                    dp[i][j] = true;
                    if (j - i + 1 > result.length()) {
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }
}