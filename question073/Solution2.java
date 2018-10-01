package question073;

public class Solution2 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m == 0){
            return;
        }
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] column = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if(row[i] == 1){
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(column[i] == 1){
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
