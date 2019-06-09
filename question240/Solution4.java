package question240;

public class Solution4 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (0 == m) {
            return false;
        }
        int n = matrix[0].length;
        if (0 == n) {
            return false;
        }
        int row = m - 1, col = 0;
        while (row >= 0 && col < n) {
            if (target < matrix[row][col]) {
                row--;
            } else if (target > matrix[row][col]) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }

}

