package question0712;

/**
 * @author qianyihui
 * @date 2019-08-20
 *
 * 动态规划。
 *
 * 状态定义：
 * 假设字符串s1的长度为n1，字符串s2的长度为n2。
 * dp[i][j]:考虑字符串s1中[i, n1 - 1]范围内的子串，以及字符串s2中[j, n2 - 1]范围内的子串，使这俩子串相等所需删除字符的ASCII值的最小和。
 *
 * 状态转移：
 * 当i == n1时，字符串s1中[i, n1 - 1]范围内的子串是空串，因此dp[i][j] = 字符串s2中[j, n2 - 1]范围内的子串所有字符的ASCII值。
 * 当j == n2时，字符串s2中[j, n2 - 1]范围内的子串是空串，因此dp[i][j] = 字符串s1中[i, n1 - 1]范围内的子串所有字符的ASCII值。
 * 当i < n1且j < n2时，
 *                  当s1.charAt(i) == s2.charAt(j)时，dp[i][j] = dp[i + 1][j + 1]。
 *                  当s1.charAt(i) != s2.charAt(j)时，dp[i][j] = min(dp[i + 1][j] + s1.charAt(i)的ASCII值, dp[i][j + 1] + s2.charAt(j)的ASCII值)
 *
 * 时间复杂度和空间复杂度均是O(n1 * n2)。
 *
 * 执行用时：44ms，击败65.52%。消耗内存：41.5MB，击败65.57%。
 */
public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = n1 - 1; i >= 0; i--) {
            dp[i][n2] = dp[i + 1][n2] + s1.charAt(i);
        }
        for (int j = n2 - 1; j >= 0; j--) {
            dp[n1][j] = dp[n1][j + 1] + s2.charAt(j);
        }
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + s1.charAt(i), dp[i][j + 1] + s2.charAt(j));
                }
            }
        }
        return dp[0][0];
    }
}
