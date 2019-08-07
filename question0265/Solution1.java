package question0265;

/**
 * @author qianyihui
 * @date 2019-08-07
 *
 * 动态规划。和question0256同样的思路。
 *
 * 时间复杂度是O(nk^2)。空间复杂度是O(nk)。
 *
 * 执行用时：14ms，击败22.58%。消耗内存：44.9MB，击败100.00%。
 */
public class Solution1 {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (n == 0) {
            return 0;
        }
        int k = costs[0].length;
        if (k == 1 && n == 1) {
            return costs[0][0];
        }
        int[][] dp = new int[n][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                for (int l = 0; l < k; l++) {
                    if (l != j) {
                        min = Math.min(min, dp[i - 1][l]);
                    }
                }
                dp[i][j] = min + costs[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(dp[n - 1][i], min);
        }
        return min;
    }
}
