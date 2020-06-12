package question0639_decode_ways_ii;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i] 表示字符串 s 中 [0, i) 范围内的子串解码得到的结果数量。
 *
 * 初始化条件：
 * （1）dp[0] = 1。
 * （2）如果 s 中首字符是 *，dp[1] = 9；如果 s 中首字符是 1 ~ 9，dp[1] = 1；如果 s 中首字符是 0，dp[1] = 0。
 *
 * 状态转移方程：
 * 较复杂，见代码。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为字符串 s 的长度。
 *
 * 执行用时：92ms，击败9.80%。消耗内存：70.4MB，击败50.00%。
 */
public class Solution2 {
    public int numDecodings(String s) {
        int MOD = 1000000007;
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) == '*') {
            dp[1] = 9;
        } else if (s.charAt(0) != '0') {
            dp[1] = 1;
        }
        for (int i = 2; i <= s.length(); i++) {
            char c1 = s.charAt(i - 1), c2 = s.charAt(i - 2);
            if (c1 == '*') {
                dp[i] = dp[i - 1] * 9;
                if (c2 == '*') {
                    dp[i] += dp[i - 2] * 15;
                } else if (c2 == '1') {
                    dp[i] += dp[i - 2] * 9;
                } else if (c2 == '2') {
                    dp[i] += dp[i - 2] * 6;
                }
            } else if (c1 == '0') {
                if (c2 == '*') {
                    dp[i] = 2 * dp[i - 2];
                } else if (c2 == '1' || c2 == '2') {
                    dp[i] = dp[i - 2];
                }
            } else if (c1 <= '6') {
                dp[i] = dp[i - 1];
                if (c2 == '*') {
                    dp[i] += dp[i - 2] * 2;
                } else if (c2 == '1' || c2 == '2') {
                    dp[i] += dp[i - 2];
                }
            } else {
                dp[i] = dp[i - 1];
                if (c2 == '*' || c2 == '1') {
                    dp[i] += dp[i - 2];
                }
            }
            dp[i] %= MOD;
        }
        return (int) dp[s.length()];
    }
}