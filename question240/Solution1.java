package question240;

public class Solution1 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (0 == m) {
            return false;
        }
        int n = matrix[0].length;
        if (0 == n) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
