package question1641_count_sorted_vowel_strings;

import java.util.Arrays;

/**
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：35.3MB，击败48.91%。
 */
public class Solution {
    public int countVowelStrings(int n) {
        // dp[i][0] 表示第 i 位是 'a' 的满足条件的 [0, i] 字符串数量
        int[][] dp = new int[n][5];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i][0] + dp[i - 1][1];
            dp[i][2] = dp[i][1] + dp[i - 1][2];
            dp[i][3] = dp[i][2] + dp[i - 1][3];
            dp[i][4] = dp[i][3] + dp[i - 1][4];
        }
        return dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2] + dp[n - 1][3] + dp[n - 1][4];
    }
}