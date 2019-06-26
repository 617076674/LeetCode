package question073;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82892394
 */
public class Solution3 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;
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
