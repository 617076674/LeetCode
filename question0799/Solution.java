package question0799;

/**
 * @author qianyihui
 * @date 2019-08-14
 *
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j]:流进第i行第j个杯子的红酒数量
 *
 * 状态转移：
 * dp[0][0] = poured
 *
 * 当是第i层的第一个杯子时，dp[i][0] = Math.max(dp[i - 1][0] - 1, 0) * 0.5。
 * 当是第i层的最后一个杯子时，dp[i][i] = Math.max(dp[i - 1][i - 1] - 1, 0) * 0.5。
 * 否则，对于第i层的第j个杯子，可以从上一层的左右两个杯子同时流入，
 * dp[i][j] = Math.max(dp[i - 1][j - 1] - 1, 0) * 0.5 + Math.max(dp[i - 1][j] - 1, 0) * 0.5;
 *
 * 时间复杂度和空间复杂度均是O(query_row ^ 2)。
 *
 * 执行用时：18ms，击败34.09%。消耗内存：39.9MB，击败70.59%。
 */
public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = poured * 1.0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] - 1, 0) * 0.5;
            dp[i][i] = Math.max(dp[i - 1][i - 1] - 1, 0) * 0.5;
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] - 1, 0) * 0.5 + Math.max(dp[i - 1][j] - 1, 0) * 0.5;
            }
        }
        return Math.min(dp[query_row][query_glass], 1);
    }
}
