package lcci0107_rotate_matrix;

/**
 * 原地旋转。
 *
 * 时间复杂度是O(n ^ 2)，其中n为矩阵matrix的行数。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.8MB，击败100.00%。
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n;
        if (null == matrix || (n = matrix.length) == 0) {
            return;
        }
        for (int k = 0; k < ((n + 1) >> 1); k++) {
            for (int i = k; i < n - k - 1; i++) {
                int tmp = matrix[i][k];
                matrix[i][k] = matrix[n - 1 - k][i];
                matrix[n - 1 - k][i] = matrix[n - 1 - i][n - 1 - k];
                matrix[n - 1 - i][n - 1 - k] = matrix[k][n - 1 - i];
                matrix[k][n - 1 - i] = tmp;
            }
        }
    }
}