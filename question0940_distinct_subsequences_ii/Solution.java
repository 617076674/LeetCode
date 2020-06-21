package question0940_distinct_subsequences_ii;

import java.util.Arrays;

/**
 * 状态定义：
 * dp[i] 表示以 S 中 [0, i] 范围内的子串含有的子序列（包括空子序列）个数。
 *
 * 初始化条件：
 * dp[0] = 1。
 *
 * 状态转移方程：
 * 对于 S = "abab" 的情况：
 * 当 i == 0 时，dp[0] = 2，有 ""、"a"。
 * 当 i == 1 时，dp[1] = 4，有 ""、"a"、"b"、"ab"。
 * 当 i == 2 时，dp[2] = 7，有 ""、"a"、"b"、"ab"、"aa"、"aba"、"ba"。
 * 当 i == 3 时，dp[3] = 12，有 ""、"a"、"b"、"ab"、"aa"、"aba"、"ba"、"abab"、"aab"、"bab"、"abb"、"bb"。
 *
 * dp[i] = dp[i - 1] * 2 - dp[last(S.charAt(i)) - 1]。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为字符串 S 的长度。
 *
 * 执行用时：5ms，击败54.37%。消耗内存：38.4MB，击败50.00%。
 */
public class Solution {
    public int distinctSubseqII(String S) {
        int[] dp = new int[S.length()], lasts = new int[26];
        Arrays.fill(lasts, -1);
        dp[0] = 2;
        int MOD = 1000000007;
        lasts[S.charAt(0) - 'a'] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] * 2;
            char c = S.charAt(i);
            int last = lasts[c - 'a'];
            if (last == 0) {
                dp[i]--;
            } else if (last != -1) {
                dp[i] -= dp[last - 1];
            }
            if (dp[i] < 0) {
                dp[i] += MOD;
            }
            dp[i] %= MOD;
            lasts[c - 'a'] = i;
        }
        return dp[S.length() - 1] - 1;
    }
}