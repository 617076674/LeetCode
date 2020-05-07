package question0072_edit_distance;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 *
 * 动态规划。
 *
 * 状态定义：
 *
 * dp[i][j]：word1中[0, i - 1]范围内的字符串转换成word2中[0, j - 1]范围内的字符串所需要的最少操作步骤。
 *
 * 状态转移：
 *
 * （1）如果i == 0或者j == 0，说明转换的字符串之中有一个是空串，其转换为另一个字符串所需要的最少操作数显然就是另一个字符串的长度。
 *
 * 因此对于i == 0的情况，dp[0, j] = j。对于j == 0的情况，dp[i, 0] = i。
 *
 * （2）如果i和j均不为0且word1.charAt(i - 1) == word2.charAt(j - 1)，显然dp[i, j] = dp[i - 1, j - 1]。
 *
 * 因为此时我们不需要考虑word1.charAt(i - 1)与word2.charAt(j - 1)之间的转换，
 *
 * word1中[0, i - 1]范围内的字符串转换成word2中[0, j - 1]范围内的字符串所需要的最少操作步骤和
 *
 * word1中[0, i - 2]范围内的字符串转换成word2中[0, j - 2]范围内的字符串所需要的最少操作步骤相同。
 *
 * （3）如果i和j均不为0且word1.charAt(i - 1) != word2.charAt(j - 1)，这又分为三种情况
 *
 * a.如果是从dp[i - 1, j - 1]状态转移过来的，dp[i - 1, j - 1]代表word1中[0, i - 2]范围内的字符串转换成word2中[0, j - 2]范围内
 *
 * 的字符串所需要的最少操作步骤。从dp[i, j]转移到dp[i - 1, j - 1]需多走一步，
 *
 * 即修改word1中i - 1位置的字符使其和word2中j - 1的字符相等。此时dp[i, j] = dp[i - 1, j - 1) + 1。
 *
 * b.如果是从dp[i - 1, j]状态转移过来的，dp[i - 1, j]代表word1中[0, i - 2]范围内的字符串转换成word2中[0, j - 1]范围内的字符串所需
 *
 * 要的最少操作步骤。从dp[i, j]转移到dp[i - 1, j]需多走一步，即在word1中删除第i - 1位置的字符。此时dp[i, j] = dp[i - 1, j] + 1。
 *
 * c.如果是从dp[i, j - 1]状态转移过来的，dp[i, j - 1]代表word1中[0, i - 1]范围内的字符串转换成word2中[0, j - 2]范围内的字符串所需
 *
 * 要的最少操作步骤。从dp[i, j]转移到dp[i, j - 1]需多走一步，即在word1中增加word2中第j - 1位置的字符。此时dp[i, j] = dp[i, j - 1] + 1。
 *
 * 由于题目要求的是最少操作数，因此应该取a、b、c三种情况中的最小值。
 *
 * 时间复杂度和空间复杂度均是O(m * n)，其中m为word1字符串的长度，n为word2字符串的长度。
 *
 * 执行用时：12ms，击败12.02%。消耗内存：45.9MB，击败5.03%。
 */
public class Solution1 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}