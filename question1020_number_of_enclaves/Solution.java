package question1020_number_of_enclaves;

public class Solution {

    private int m, n;

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j);
            }
            if (grid[m - 1][j] == 1) {
                dfs(grid, m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][n - 1] == 1) {
                dfs(grid, i, n - 1);
            }
        }
        int result = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int x, int y) {
        grid[x][y] = -1;
        for (int i = 0; i < directions.length; i++) {
            int nextX = x + directions[i][0], nextY = y + directions[i][1];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1) {
                dfs(grid, nextX, nextY);
            }
        }
    }

}