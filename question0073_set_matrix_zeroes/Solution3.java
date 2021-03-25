package question0073_set_matrix_zeroes;

/**
 * 如果矩阵matrix的每一行都包含0，我们把整个矩阵都置为0。
 *
 * 如果并不是每一行都包含0，基于Solution2的思路，我们需要用一些标记来标识某一行或是某一列是否存在0。其实Solution2的思路可以进一步改进。
 *
 * 我们先寻找到一行row，该行不包含0元素。遍历该行中每一个元素对应的每一列，如果该列中包含0，将该行中的该元素置0。
 *
 * 除去第row行外的其他行，如果有包含0的，将这些行均置为0。
 *
 * 对于第row行元素中的0元素，将其对应的列置为0。
 *
 * 这个思路的本质就是将包含0的列的标记记录在了一个不包含0的第row行，而没有使用额外的存储空间。
 *
 * 时间复杂度是O(m * n)。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：51MB，击败5.07%。
 */
public class Solution3 {
    public void setZeroes(int[][] matrix) {
        int m;
        if (null == matrix || (m = matrix.length) == 0) {
            return;
        }
        int n;
        if (null == matrix[0] || (n = matrix[0].length) == 0) {
            return;
        }
        //try to find a row without 0
        int row = 0;
        for (; row < m; row++) {
            int column = 0;
            for (; column < n; column++) {
                if (matrix[row][column] == 0) {
                    break;
                }
            }
            if (column == n) {
                break;
            }
        }
        if (row == m) {
            //every row contains 0
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[j][i] == 0) {
                        matrix[row][i] = 0;
                    }
                }
            }
            //make other row contains 0 to 0
            for (int i = 0; i < m; i++) {
                if (i == row) {
                    continue;
                }
                int j = 0;
                for (; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        break;
                    }
                }
                if (j < n) {
                    for (int k = 0; k < n; k++) {
                        matrix[i][k] = 0;
                    }
                }
            }
            //if a position in the row we select is 0, make its column to 0
            for (int i = 0; i < n; i++) {
                if (matrix[row][i] == 0) {
                    for (int j = 0; j < m; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }
    }
}