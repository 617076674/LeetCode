package question0410;

import java.util.Arrays;

/**
 * 状态定义：
 * dp[i][j]:将nums数组中[0, i - 1]范围内的数字分成j份，其能得到的各份和中最大值的最小值。
 *
 * 初始条件：
 * dp[0][0] = 0
 *
 * 状态转移：
 * dp[i][j] = min(dp[i][j], max(dp[k][j - 1], sum[i] - sum[k]))
 *
 * 时间复杂度是O((n ^ 2) * m)，其中n为nums数组的长度。空间复杂度是O(n ^ 2)。
 *
 * 执行用时：57ms，击败15.10%。消耗内存：35MB，击败47.46%。
 */
public class Solution2 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        int[] sum = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
                }
            }
        }
        return dp[n][m];
    }
}
