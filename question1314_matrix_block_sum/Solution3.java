package question1314_matrix_block_sum;

/**
 * 用二维前缀和数组进行优化。
 *
 * 时间复杂度和空间复杂度均是 O(m * n)，其中 m 为矩阵 mat 的行数，n 为矩阵 mat 的列数。
 *
 * 执行用时：6ms，击败63.91%。消耗内存：40.6MB，击败100.00%。
 */
public class Solution3 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m][n], result = new int[m][n];//sum[i][j] 表示以 [0, 0] 为左上角，以 [i, j] 为右下角的矩阵元素和
        for (int j = 0; j < n; j++) {
            if (j == 0) {
                sum[0][j] = mat[0][j];
            } else {
                sum[0][j] = sum[0][j - 1] + mat[0][j];
            }
        }
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i - 1][0] + mat[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = Math.max(0, i - K), bottom = Math.min(i + K, m - 1), left = Math.max(0, j - K),
                        right = Math.min(j + K, n - 1);
                result[i][j] = sum[bottom][right];
                if (top != 0) {
                    result[i][j] -= sum[top - 1][right];
                }
                if (left != 0) {
                    result[i][j] -= sum[bottom][left - 1];
                    if (top != 0) {
                        result[i][j] += sum[top - 1][left - 1];
                    }
                }
            }
        }
        return result;
    }
}