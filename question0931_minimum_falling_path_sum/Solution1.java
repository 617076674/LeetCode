package question0931_minimum_falling_path_sum;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(m * n)，其中 m 是矩阵 A 的行数，n 是矩阵 A 的列数。
 *
 * 执行用时：2ms，击败99.23%。消耗内存：41.1MB，击败100.00%。
 */
public class Solution1 {
    private int m, n;

    private Integer[][] memo;

    public int minFallingPathSum(int[][] A) {
        if (null == A || (m = A.length) == 0) {
            return 0;
        }
        if (null == A[0] || (n = A[0].length) == 0) {
            return 0;
        }
        memo = new Integer[m][n];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, minFallingPathSum(A, 0, i));
        }
        return result;
    }

    private int minFallingPathSum(int[][] A, int row, int col) {
        if (row == A.length) {
            return 0;
        }
        if (memo[row][col] != null) {
            return memo[row][col];
        }
        int result = Integer.MAX_VALUE;
        if (col == 0) {
            for (int i = 0; i <= Math.min(n - 1, 1) ; i++) {
                result = Math.min(result, A[row][i] + minFallingPathSum(A, row + 1, i));
            }
        } else if (col == n - 1) {
            for (int i = n - 1; i >= Math.max(0, n - 2) ; i--) {
                result = Math.min(result, A[row][i] + minFallingPathSum(A, row + 1, i));
            }
        } else {
            for (int i = col - 1; i <= col + 1; i++) {
                result = Math.min(result, A[row][i] + minFallingPathSum(A, row + 1, i));
            }
        }
        memo[row][col] = result;
        return result;
    }
}