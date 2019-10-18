package question0840_magic_squares_in_grid;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(m * n)，其中m是grid矩阵的行数，n是grid矩阵的列数。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败91.04%。
 */
public class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m;
        if (grid == null || (m = grid.length) < 3) {
            return 0;
        }
        int n;
        if (grid[0] == null || (n = grid[0].length) < 3) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                if (isMagicSquaresInside(grid, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isMagicSquaresInside(int[][] grid, int i, int j) {
        boolean[] flag = new boolean[9];
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                if (grid[k][l] >= 1 && grid[k][l] <= 9) {
                    flag[grid[k][l] - 1] = true;
                }
            }
        }
        for (int k = 0; k < 9; k++) {
            if (!flag[k]) {
                return false;
            }
        }
        int sum = 0;
        for (int k = i; k < i + 3; k++) {
            sum += grid[k][j];
        }
        for (int k = j + 1; k < j + 3; k++) {
            int tmpSum = 0;
            for (int l = i; l < i + 3; l++) {
                tmpSum += grid[l][k];
            }
            if (tmpSum != sum) {
                return false;
            }
        }
        for (int k = i; k < i + 3; k++) {
            int tmpSum = 0;
            for (int l = j; l < j + 3; l++) {
                tmpSum += grid[k][l];
            }
            if (tmpSum != sum) {
                return false;
            }
        }
        if (sum != grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] || sum != grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j]) {
            return false;
        }
        return true;
    }
}
