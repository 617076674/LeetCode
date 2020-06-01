package question1230_toss_strange_coins;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示从第 i 枚硬币开始投起，共有 j 枚硬币正面的概率。
 *
 * 初始化条件：
 * dp[prob.length][0] = 1.0。
 * dp[prob.length][j] = 0.0, j ≠ 0。
 *
 * 状态转移方程：
 * dp[i][j] = prob[i] * dp[i + 1][j - 1] + (1 - prob[i]) * dp[i + 1][j]。
 *
 * 时间复杂度和空间复杂度均是 O(n * target)。
 *
 * 执行用时：21ms，击败63.41%。消耗内存：49.6MB，击败66.67%。
 */
public class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        double[][] dp = new double[prob.length + 1][target + 1];
        dp[prob.length][0] = 1.0;
        for (int i = prob.length - 1; i >= 0; i--) {
            for (int j = 0; j <= target; j++) {
                if (j == 0) {
                    dp[i][j] = (1 - prob[i]) * dp[i + 1][j];
                } else {
                    dp[i][j] = prob[i] * dp[i + 1][j - 1] + (1 - prob[i]) * dp[i + 1][j];
                }
            }
        }
        return dp[0][target];
    }
}