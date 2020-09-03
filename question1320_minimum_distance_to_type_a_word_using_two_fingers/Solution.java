package question1320_minimum_distance_to_type_a_word_using_two_fingers;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j][k] 表示考虑 word 中第 (i - 1) 个字符，左指在字符 j 处，右指在字符 k 处的移动总距离。
 *
 * 初始化条件：
 * dp[0][j][k] = 0。
 *
 * 状态转移方程：
 * 移动左指：dp[i][s.charAt(i - 1) - 'A'][k] = min(dp[i - 1][j][k] + distance((char) (j + 'A'), s.charAt(i - 1)))。
 * 移动右指：dp[i][j][s.charAt(i - 1) - 'A'] = min(dp[i - 1][j][k] + distance((char) (k + 'A'), s.charAt(i - 1)))。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为字符串 word 的长度。
 *
 * 执行用时：46ms，击败30.63%。消耗内存：43.6MB，击败5.77%。
 */
public class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int[][][] dp = new int[n + 1][26][26];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 26; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            char c = word.charAt(i - 1);
            // 遍历 i - 1 处字符时左指的所有位置
            for (int j = 0; j < 26; j++) {
                // 遍历 i - 1 处字符时右指的所有位置
                for (int k = 0; k < 26; k++) {
                    // 遍历 i - 1 处字符时左指右指的状态合法
                    if (dp[i - 1][j][k] != Integer.MAX_VALUE) {
                        // 移动左指
                        dp[i][c - 'A'][k] = Math.min(dp[i][c - 'A'][k], dp[i - 1][j][k] + calculateDistance(c, (char) (j + 'A')));
                        // 移动右指
                        dp[i][j][c - 'A'] = Math.min(dp[i][j][c - 'A'], dp[i - 1][j][k] + calculateDistance(c, (char) (k + 'A')));
                    }
                    if (i == n) {
                        result = Math.min(result, dp[i][c - 'A'][k]);
                        result = Math.min(result, dp[i][j][c - 'A']);
                    }
                }
            }
        }
        return result;
    }

    private int calculateDistance(char c1, char c2) {
        int[] p1 = calculatePosition(c1), p2 = calculatePosition(c2);
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    private int[] calculatePosition(char c) {
        return new int[] {(c - 'A') / 6, (c - 'A') % 6};
    }
}