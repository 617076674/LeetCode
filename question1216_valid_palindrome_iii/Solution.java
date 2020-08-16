package question1216_valid_palindrome_iii;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示令字符串 s 中 [i, j] 范围内的子串成为回文串所需删除的最少字符个数。
 *
 * 初始化条件：
 * 当 i == j 时，dp[i][j] = 0。
 *
 * 状态转移方程：
 * 当 s.charAt(i) == s.charAt(j) 时，dp[i][j] = dp[i + 1][j - 1]。
 * 当 s.charAt(i) != s.charAt(j) 时，dp[i][j] = min(dp[i + 1][j], dp[i][j - 1]) + 1。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 2)，其中 n 为字符串 s 的长度。
 *
 * 执行用时：16ms，击败25.53%。消耗内存：41.5MB，击败33.33%。
 */
public class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int gap = -1; gap >= 1 - n; gap--) {
            for (int i = 0; i < gap + n; i++) {
                int j = i - gap;
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1] <= k;
    }
}