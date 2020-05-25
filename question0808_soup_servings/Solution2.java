package question0808_soup_servings;

/**
 * 当 N 很大时，直接输出 1 即可。
 *
 * 由于分汤时以 25 为基数，所以先将 N 除以 25。
 *
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示 当前有 i 毫升的汤 A，有 j 毫升的汤 B，A 先分配完的概率。
 *
 * 初始化条件：
 * dp[0][0] = 0.5。
 * dp[i][0] = 0。
 * dp[0][i] = 1。
 *
 * 状态转移方程：
 * dp[i][j] = 0.25 * (dp[max(i - 4, 0)][j], dp[max(i - 3, 0)][max(j - 1, 0)], dp[max(i - 4, 0)][max(j - 2, 0)],
 * dp[max(i - 4, 0)][max(j - 3, 0)])。
 *
 * 时间复杂度和空间复杂度均是 O(N ^ 2)。
 *
 * 执行用时：3ms，击败79.05%。消耗内存：36.3MB，击败50.00%。
 */
public class Solution2 {
    public double soupServings(int N) {
        if (N >= 3276) {
            return 1.0;
        }
        int n = (int) Math.ceil(N / 25.0);
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i < n + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = 0.25 * (dp[Math.max(i - 4, 0)][j] + dp[Math.max(i - 3, 0)][Math.max(j - 1, 0)] +
                        dp[Math.max(i - 2, 0)][Math.max(j - 2, 0)] + dp[Math.max(i - 1, 0)][Math.max(j - 3, 0)]);
            }
        }
        return dp[n][n];
    }
}