package question0664;

/**
 * @author qianyihui
 * @date 2019-08-15
 *
 * 动态规划。
 *
 * 状态定义：
 * dp[i, j]:打印[i, j]范围内的字符串所需的最少次数
 *
 * 状态转移：
 * 当i == j时，dp[i][j] = 1。
 *
 * 当i != j时，只需考虑i < j的情形，可以分成如下三种情况来进行讨论
 * （1）将第i个字符单独打印，[i + 1, j]中的字符另外打印，dp[i][j] = 1 + dp[i + 1][j]
 * （2）尝试将[i, j]分成两段，分别是[i, k]和[k + 1, j]，
 * 如果s.charAt(i) == s.charAt(k)，则可以将i放进[i + 1, k]中一起打印，
 * 因此dp[i][j] = dp[i + 1][k] + dp[k + 1][j]，其中k∈[i + 1, j - 1]
 * （3）如果s.charAt(i) == s.charAt(j)，可以把i放入[i + 1, j]中一起打印，
 * 因此dp[i][j] = dp[i + 1][j]
 *
 * 取上述三种情形的最小值就是dp[i][j]值。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为字符串s的长度。
 *
 * 执行用时：45ms，击败61.29%。内存消耗：37.3MB，击败81.25%。
 */
public class Solution {
    public int strangePrinter(String s) {
        int n;
        if (s == null || (n = s.length()) == 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                //i单独打印，s[i + 1, j]段另外打印
                dp[i][j] = 1 + dp[i + 1][j];
                //尝试将s[i, j]分成s[i, k]和[k + 1, j]
                for (int k = i + 1; k < j; k++) {
                    if (s.charAt(i) == s.charAt(k)) {
                        //dp[i + 1][k]代表将i放到[i + 1, k]一起打印，dp[k + 1][j]代表[k + 1, j]另外打印
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][k] + dp[k + 1][j]);
                    }
                }
                if (s.charAt(i) == s.charAt(j)) {
                    //dp[i + 1][j]代表将i放入[j + 1, i]一起打印
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}