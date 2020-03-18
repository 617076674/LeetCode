package question0471_encode_string_with_shortest_length;

/**
 * 动态规划。
 *
 * 状态定义：
 *
 * dp[i][j]：字符串s中[i, j]范围内的子串能获得的最短压缩字符串。
 *
 * 状态转移：
 *
 * （1）dp[i][j] = minLen(dp[i][k] + dp[k + 1][j]), k∈[i, j)。
 *
 * （2）如果字符串s中[i, j]范围内的子串能够由[i, i + index - 1]范围内的子串重复repeatedTimes构建而成，
 * 则dp[i][j] = minLen(dp[i][j], repeatedTimes + [ + dp[i][i + index - 1] + ])。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为字符串s的长度。
 *
 * 执行用时：40ms，击败42.03%。消耗内存：42.7MB，击败40.00%。
 */
public class Solution2 {
    public String encode(String s) {
        int n;
        if (null == s || (n = s.length()) < 5) {
            return s;
        }
        String[][] dp = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.substring(i, j + 1);
            }
        }
        for (int gap = 0; gap >= 1 - n; gap--) {
            for (int i = 0; i < n + gap; i++) {
                int j = i - gap;
                if (j - i > 3) {
                    for (int k = i; k < j; k++) {
                        String left = dp[i][k], right = dp[k + 1][j];
                        if (left.length() + right.length() < dp[i][j].length()) {
                            dp[i][j] = left + right;
                        }
                    }
                    String tmp = s.substring(i, j + 1);
                    int index = (tmp + tmp).indexOf(tmp, 1);
                    if (index < n) {
                        int repeateTimes = tmp.length() / index;
                        if ((repeateTimes + "[" + dp[i][i + index - 1] + "]").length() < dp[i][j].length()) {
                            dp[i][j] = repeateTimes + "[" + dp[i][i + index - 1] + "]";
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}