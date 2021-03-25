package question0073_set_matrix_zeroes;

/**
 * 记录哪些行和列应该置为0。
 *
 * 时间复杂度为O(mn)，其中m是矩阵matrix的行数，n是矩阵matrix的列数。空间复杂度为O(m + n)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：49.2MB，击败5.39%。
 */
public class Solution2 {
    public void setZeroes(int[][] matrix) {
        int m;
        if (null == matrix || (m = matrix.length) == 0) {
            return;
        }
        int n;
        if (null == matrix[0] || (n = matrix[0].length) == 0) {
            return;
        }
        int[] row = new int[m], column = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (row[i] == 1) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (column[i] == 1) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}