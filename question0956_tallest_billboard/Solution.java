package question0956_tallest_billboard;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示使用 [0, i - 1] 范围内的钢筋，构成高度差为 j 的两根钢柱，其最大公共高度值。
 *
 * 初始化条件：
 * dp[0][0] = 0。
 *
 * 状态转移方程：
 *
 * （1）选择不放置第 i - 1 根钢筋：dp[i][j] = dp[i - 1][j]。
 * （2）选择将第 i - 1 根钢筋放在较高的柱子上：dp[i][j] = dp[i - 1][j - rods[i - 1]]。
 * （3）选择将第 i - 1 根钢筋放在教矮的柱子上：
 * dp[i][j] = max(dp[i - 1][j + rods[i - 1]] + rods[i - 1], dp[i - 1][rods[i - 1] - j] + rods[i - 1] - j)。
 *
 * 时间复杂度和空间复杂度均是 O(rods.length * 5001)。
 *
 * 执行用时：37ms，击败26.00%。消耗内存：40MB，击败100.00%。
 */
public class Solution {
    public int tallestBillboard(int[] rods) {
        int[][] dp = new int[rods.length + 1][5001];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i - 1][j] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j >= rods[i - 1] && dp[i - 1][j - rods[i - 1]] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - rods[i - 1]]);
                }
                if (j + rods[i - 1] < dp[0].length && dp[i - 1][j + rods[i - 1]] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + rods[i - 1]] + rods[i - 1]);
                }
                if (rods[i - 1] - j >= 0 && dp[i - 1][rods[i - 1] - j] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][rods[i - 1] - j] + rods[i - 1] - j);
                }
            }
        }
        return dp[rods.length][0];
    }
}