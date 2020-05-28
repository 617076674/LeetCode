package question1130_minimum_cost_tree_from_leaf_values;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示数组 arr 中 [i, j] 范围内的元素所能构成满足题意的二叉树的每个非叶子节点的总和的最小值。
 *
 * 初始化条件：
 * 当 i == j 时，dp[i][j] = 0。
 *
 * 状态转移方程：
 * dp[i][j] = min(dp[i][k] + dp[k + 1][j] + max(arr[i], ..., arr[k]) * max(arr[k + 1], ..., arr[j])), k ∈ [i, j)。
 *
 * 时间复杂度是 O(n ^ 3)。空间复杂度是 O(n ^ 2)，其中 n 为数组 arr 的长度。
 *
 * 执行用时：5ms，击败58.55%。消耗内存：37.8MB，击败100.00%。
 */
public class Solution2 {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n], max = new int[n][n];
        for (int i = 0; i < n; i++) {
            max[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) {
                max[i][j] = Math.max(max[i][j - 1], arr[j]);
            }
        }
        for (int gap = -1; gap >= 1 - n; gap--) {
            for (int i = 0; i <= gap + n - 1; i++) {
                int j = i - gap;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}