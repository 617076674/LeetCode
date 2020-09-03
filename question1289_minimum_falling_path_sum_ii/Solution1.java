package question1289_minimum_falling_path_sum_ii;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示前 i 行的非零偏移下降路径数字和，其第 i 行的下降位置纵坐标是 j。
 *
 * 初始化条件：
 * dp[0][j] = arr[0][j]。
 *
 * 状态转移方程：
 * dp[i][j] = min(dp[i - 1][k] + arr[i][j]), k != j。
 *
 * 时间复杂度是 O(n ^ 3)，其中 n 为 arr 数组的长度。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：77ms，击败14.29%。消耗内存：46.4MB，击败44.83%。
 */
public class Solution1 {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = arr[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        dp[i][j] = Math.min(dp[i][j], arr[i][j] + dp[i - 1][k]);
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            result = Math.min(dp[n - 1][j], result);
        }
        return result;
    }
}