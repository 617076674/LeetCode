package question1504_count_submatrices_with_all_ones;

public class Solution1 {

    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] leftOnes = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    leftOnes[i][j] = mat[i][j];
                } else if (mat[i][j] != 0) {
                    leftOnes[i][j] = leftOnes[i][j - 1] + 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cols = leftOnes[i][j];
                for (int k = i; k >= 0 && cols > 0; k--) {
                    cols = Math.min(cols, leftOnes[k][j]);
                    result += cols;
                }
            }
        }
        return result;
    }

}