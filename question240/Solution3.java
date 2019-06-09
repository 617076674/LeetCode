package question240;

public class Solution3 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (0 == m) {
            return false;
        }
        int n = matrix[0].length;
        if (0 == n) {
            return false;
        }
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }

}

