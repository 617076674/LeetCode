package question0486_predict_the_winner;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j]:nums数组中[i, j]范围内的数据，先取者能取得的最大值。
 *
 * 状态转移：
 * 当i == j时，dp[i][j] = nums[i]。
 * 当i < j时，dp[i][j] = sum(i, j) - Math.min(dp[i + 1][j], dp[i][j - 1])，其中sum(i, j)为nums数组中[i, j]范围内的和。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为nums数组的长度。
 *
 * 执行用时：2ms，击败55.19%。消耗内存：35MB，击败81.82%。
 */
public class Solution3 {

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1]; // sums[i] 表示 nums 数组中 [0, i - 1] 范围内元素总和，那么 sums[i] - sums[j] 代表 nums 数组中 [j, i - 1] 范围内的元素和
        int[][] dp = new int[n][n];
        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int gap = -1; gap >= 1 - n; gap--) {
            for (int i = 0; i < n + gap; i++) {
                int j = i - gap;
                dp[i][j] = sums[j + 1] - sums[i] - Math.min(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= sums[n] - dp[0][n - 1];
    }
}