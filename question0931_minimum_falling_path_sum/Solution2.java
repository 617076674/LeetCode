package question0931_minimum_falling_path_sum;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示当前在第 i 行，第 j 列，从当前位置开始的下降路径的最小和。
 *
 * 初始化条件：
 * dp[A.length - 1][j] = A[A.length - 1][j]。
 *
 * 状态转移方程：
 * dp[i][j] = min(dp[i + 1][j - 1], dp[i + 1, j], dp[i + 1][j + 1])。
 *
 * 可以在原数组 A 上修改，避免创建新的 dp 数组。
 *
 * 时间复杂度是 O(m * n)，其中 m 是矩阵 A 的行数，n 是矩阵 A 的列数。空间复杂度是 O(1)。
 *
 * 执行用时：6ms，击败44.04%。消耗内存：40.1MB，击败100.00%。
 */
public class Solution2 {
    public int minFallingPathSum(int[][] A) {
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = 0; j < A.length; j++) {
                int tmp = A[i + 1][j];
                if (j > 0) {
                    tmp = Math.min(tmp, A[i + 1][j - 1]);
                }
                if (j + 1 < A.length) {
                    tmp = Math.min(tmp, A[i + 1][j + 1]);
                }
                A[i][j] += tmp;
            }
        }
        return Arrays.stream(A[0]).min().getAsInt();
    }
}