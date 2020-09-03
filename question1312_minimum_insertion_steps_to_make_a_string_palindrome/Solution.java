package question1312_minimum_insertion_steps_to_make_a_string_palindrome;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示对于字符串 s 中 [i, j] 范围内的字符串，将其转换为回文串所需删除的最少字符个数。
 *
 * 初始化条件：
 * dp[i][i] = 0。
 *
 * 状态转移方程：
 * dp[i][j]
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 2)。
 *
 * 执行用时：24ms，击败30.27%。消耗内存：41.2MB，击败7.32%。
 */
public class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int gap = -1; gap >= 1 - n; gap--) {
            for (int i = 0; i < n + gap; i++) {
                int j = i - gap;
                if (j - i == 1) {
                    if (s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = 1;
                    }
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}