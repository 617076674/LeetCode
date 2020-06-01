package question1314_matrix_block_sum;

/**
 * 暴力破解法。
 *
 * 时间复杂度是 O(m * n * K ^ 2)，其中 m 为矩阵 mat 的行数，n 为矩阵 mat 的列数。空间复杂度是 O(m * n)。
 *
 * 执行用时：298ms，击败10.74%。消耗内存：40.6MB，击败100.00%。
 */
public class Solution1 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int r = Math.max(0, i - K); r <= Math.min(i + K, m - 1); r++) {
                    for (int c = Math.max(0, j - K); c <= Math.min(j + K, n - 1); c++) {
                        result[i][j] += mat[r][c];
                    }
                }
            }
        }
        return result;
    }
}