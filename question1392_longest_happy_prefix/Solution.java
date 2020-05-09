package question1392_longest_happy_prefix;

/**
 * 动态规划（KMP算法）。
 *
 * 在 s[1:] 中匹配s。
 *
 * 状态定义：
 * dp[i][j] 表示当前状态是 i，在该状态下如果遇到字符 s.charAt(j) 将会转移到的新状态
 *
 * 状态转移：
 * （1）dp[i][j] = dp[X][j]，其中 X 是影子状态，状态重启。
 * （2）dp[i][s.charAt(i) - 'a'] = i + 1，状态推进。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串s的长度。
 *
 * 执行用时：97ms，击败14.16%。消耗内存：67MB，击败100.00%。
 */
public class Solution {
    public String longestPrefix(String s) {
        int[][] dp = new int[s.length()][26];
        dp[0][s.charAt(0) - 'a'] = 1;
        int X = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = dp[X][j];
            }
            dp[i][s.charAt(i) - 'a'] = i + 1;
            X = dp[X][s.charAt(i) - 'a'];
        }
        return s.substring(0, X);
    }
}