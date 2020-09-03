package question1278_palindrome_partitioning_iii;

import java.util.Arrays;

/**
 * 时间复杂度是 O(k * n ^ 2)，其中 n 为字符串 s 的长度。空间复杂度是 O(k * n)。
 *
 * 执行用时：5ms，击败96.36%。消耗内存：37.7MB，击败55.00%。
 */
public class Solution {
    private int[][] memo;

    private int[][] dp;

    public int palindromePartition(String s, int k) {
        memo = new int[k + 1][s.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        dp = new int[s.length()][s.length()];
        for (int gap = -1; gap >= 1 - s.length(); gap--) {
            for (int i = 0; i <= gap + s.length() - 1; i++) {
                int j = i - gap;
                boolean flag = s.charAt(i) != s.charAt(j);
                if (j - i == 1) {
                    if (flag) {
                        dp[i][j] = 1;
                    }
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                    if (flag) {
                        dp[i][j]++;
                    }
                }
            }
        }
        return palindromePartition(s, k, 0);
    }

    /**
     * 将字符串 s 中 [index, s.length - 1] 范围内的子串划分为 k 个回文串，所需修改的最少字符数
     */
    private int palindromePartition(String s, int k, int index) {
        if (s.length() - index <= k) {
            return 0;
        }
        if (k == 1) {
            return dp[index][s.length() - 1];
        }
        if (memo[k][index] != -1) {
            return memo[k][index];
        }
        memo[k][index] = Integer.MAX_VALUE / 2;
        for (int i = index; i < s.length(); i++) {
            memo[k][index] = Math.min(palindromePartition(s, k - 1, i + 1) + dp[index][i], memo[k][index]);
        }
        return memo[k][index];
    }
}