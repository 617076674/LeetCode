package question1155_number_of_dice_rolls_with_target_sum;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示用 i 颗骰子掷出和 j 的组合数。
 *
 * 初始化条件：
 * dp[1][j] = 1, j ∈ [1, min(f, target)]。
 *
 * 状态转移方程：
 * dp[i][j] = dp[i - 1][j - k], k ∈ [1, Math.min(f, j)]。
 *
 * 时间复杂度是 O((fd) ^ 2)。空间复杂度是 O(f * d ^ 2)。
 *
 * 执行用时：39ms，击败36。70%。消耗内存：38.9MB，击败100.00%。
 */
public class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d + 1][Math.max(d * f, target) + 1];
        for (int j = 1; j <= Math.min(f, target); j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= d; i++) {
            for (int j = i; j <= d * f; j++) {
                for (int k = 1; k <= Math.min(f, j); k++) {
                    dp[i][j] += dp[i - 1][j - k];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        return dp[d][target];
    }
}