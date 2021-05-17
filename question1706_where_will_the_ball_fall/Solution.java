package question1706_where_will_the_ball_fall;

public class Solution {

    private int m, n;

    private Integer[][] memo;

    public int[] findBall(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[] result = new int[n];
        memo = new Integer[m][n];
        for (int i = 0; i < n; i++) {
            result[i] = out(grid, i, 0);
        }
        return result;
    }

    private int out(int[][] grid, int col, int row) {
        if (row == m) {
            return col;
        }
        if ((col == 0 && grid[row][col] == -1)
            || (col == n - 1 && grid[row][col] == 1)
            || (grid[row][col] == 1 && grid[row][col + 1] == -1)
            || (grid[row][col] == -1 && grid[row][col - 1] == 1)) {
            return -1;
        }
        if (memo[row][col] != null) {
            return memo[row][col];
        }
        memo[row][col] = out(grid, col + grid[row][col], row + 1);
        return memo[row][col];
    }

}