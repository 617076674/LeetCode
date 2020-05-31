package question1223_dice_roll_simulation;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j][k] 表示前 j 次掷骰子得到的值均是 k，在这种情况下掷 i 次骰子能得到的序列数量。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：126ms，击败7.30%。消耗内存：42.3MB，击败100.00%。
 */
public class Solution2 {
    public int dieSimulator(int n, int[] rollMax) {
        int[][][] dp = new int[n + 1][16][7];
        int MOD = 1000000007;
        for (int j = 1; j < 16; j++) {
            for (int k = 1; k < 7; k++) {
                for (int l = 0; l < 6; l++) {
                    if (l + 1 != k || (l + 1 == k && rollMax[l] >= j + 1)) {
                        dp[1][j][k]++;
                    }
                }
            }
        }
        for (int i = 2; i < n + 1; i++) {
            for (int l = 0; l < 6; l++) {
                dp[i][0][0] += dp[i - 1][1][l + 1];
                dp[i][0][0] %= MOD;
            }
            if (i == n) {
                return dp[i][0][0];
            }
            for (int j = 1; j < 16; j++) {
                for (int k = 1; k < 7; k++) {
                    for (int l = 0; l < 6; l++) {
                        if (k == l + 1 && rollMax[l] >= j + 1) {
                            dp[i][j][k] += dp[i - 1][j + 1][l + 1];
                        } else if (k != l + 1) {
                            dp[i][j][k] += dp[i - 1][1][l + 1];
                        }
                        dp[i][j][k] %= MOD;
                    }
                }
            }
        }
        return -1;
    }
}