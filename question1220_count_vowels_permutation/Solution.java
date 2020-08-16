package question1220_count_vowels_permutation;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示最后一个字母代表的数字是 j，能组成长度为 i 的字符串的个数。
 * ('a' 代表 0，'e' 代表 1，'i' 代表 2，'o' 代表 3，'u' 代表 4。）
 *
 * 初始化条件：
 * dp[0][j] = 0。
 * dp[1][j] = 1。
 *
 * 状态转移方程：
 * dp[i][0] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]。
 * dp[i][1] = dp[i - 1][0] + dp[i - 1][2]。
 * dp[i][2] = dp[i - 1][1] + dp[i - 1][3]。
 * dp[i][3] = dp[i - 1][2]。
 * dp[i][4] = dp[i - 1][2] + dp[i - 1][3]。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：20ms，击败51.00%。消耗内存：39.5MB，击败36.36%。
 */
public class Solution {
    public int countVowelPermutation(int n) {
        if (n == 0) {
            return 1;
        }
        int[][] dp = new int[n + 1][5];
        int MOD = 1000000007;
        Arrays.fill(dp[1], 1);
        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = ((dp[i - 1][1] + dp[i - 1][2]) % MOD + dp[i - 1][4]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % MOD;
            dp[i][3] = dp[i - 1][2];
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
        }
        int result = dp[n][0];
        for (int i = 1; i < 5; i++) {
            result = (result + dp[n][i]) % MOD;
        }
        return result;
    }
}