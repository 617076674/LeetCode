package question1314_matrix_block_sum;

/**
 * 前缀和数组进行一层优化。
 *
 * 时间复杂度是 O(m * n * K)，其中 m 为矩阵 mat 的行数，n 为矩阵 mat 的列数。空间复杂度是 O(m * n)。
 *
 * 执行用时：13ms，击败33.06%。消耗内存：40.8MB，击败100.00%。
 */
public class Solution2 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m][n], result = new int[m][n];    //sum[i][j] 表示第 i 行中 [0, j] 范围内的元素和
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    sum[i][j] = mat[i][j];
                } else {
                    sum[i][j] = mat[i][j] + sum[i][j - 1];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int r = Math.max(0, i - K); r <= Math.min(i + K, m - 1); r++) {
                    int left = Math.max(0, j - K), right = Math.min(j + K, n - 1);
                    result[i][j] += sum[r][right];
                    if (left != 0) {
                        result[i][j] -= sum[r][left - 1];
                    }
                }
            }
        }
        return result;
    }
}