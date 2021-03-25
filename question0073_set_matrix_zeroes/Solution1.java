package question0073_set_matrix_zeroes;

/**
 * 用一个m * n的矩阵记录哪些位置是0。
 *
 * 时间复杂度和空间复杂度均是O(mn)，其中m是矩阵matrix的行数，n是矩阵matrix的列数。
 *
 * 执行用时：2ms，击败57.69%。消耗内存：49.6MB，击败5.07%。
 */
public class Solution1 {
    public void setZeroes(int[][] matrix) {
        int m;
        if (null == matrix || (m = matrix.length) == 0) {
            return;
        }
        int n;
        if (null == matrix[0] || (n = matrix[0].length) == 0) {
            return;
        }
        int[][] flag = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    flag[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flag[i][j] == 1) {
                    for (int k = 0; k < m; k++) {
                        matrix[k][j] = 0;
                    }
                    for (int k = 0; k < n; k++) {
                        matrix[i][k] = 0;
                    }
                }
            }
        }
    }
}