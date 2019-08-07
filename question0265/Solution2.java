package question0265;

/**
 * @author qianyihui
 * @date 2019-08-07
 *
 * 对Solution1的改进，在求某层dp数组的时候记录其最小值和次小值的索引。
 *
 * 时间复杂度和空间复杂度均是O(nk)。
 *
 * 执行用时：14ms，击败22.58%。消耗内存：44.9MB，击败100.00%。
 */
public class Solution2 {
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
        // 求取dp[0][i]中的最小值索引min1和第二小值索引min2
        int min1 = -1, min2 = -1;
        for (int i = 0; i < k; i++) {
            if (min1 == -1 || dp[0][i] < dp[0][min1]) {
                min2 = min1;
                min1 = i;
            } else if (min2 == -1 || dp[0][i] < dp[0][min2]) {
                min2 = i;
            }
        }
        for (int i = 1; i < n; i++) {
            int tmpMin1 = -1, tmpMin2 = -1;
            for (int j = 0; j < k; j++) {
                if (j == min1) {
                    dp[i][j] = dp[i - 1][min2] + costs[i][j];
                } else {
                    dp[i][j] = dp[i - 1][min1] + costs[i][j];
                }
                if (tmpMin1 == -1 || dp[i][j] < dp[i][tmpMin1]) {
                    tmpMin2 = tmpMin1;
                    tmpMin1 = j;
                } else if (tmpMin2 == -1 || dp[i][j] < dp[i][tmpMin2]) {
                    tmpMin2 = j;
                }
            }
            min1 = tmpMin1;
            min2 = tmpMin2;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(dp[n - 1][i], min);
        }
        return min;
    }
}
