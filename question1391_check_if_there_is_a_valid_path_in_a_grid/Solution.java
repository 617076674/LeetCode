package question1391_check_if_there_is_a_valid_path_in_a_grid;

/**
 * 深搜。
 *
 * 时间复杂度和空间复杂度均是O(m * n)。
 *
 * 执行用时：14ms，击败75.00%。消耗内存：63.5MB，击败100.00%。
 */
public class Solution {
    private boolean result;

    private boolean[][] visited;

    private int m, n;

    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        dfs(grid, 0, 0);
        return result;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (result) {
            return;
        }
        if (x == m - 1 && y == n - 1) {
            result = true;
            return;
        }
        switch (grid[x][y]) {
            case 1:
                if (y + 1 < n && !visited[x][y + 1] && (grid[x][y + 1] == 1 || grid[x][y + 1] == 3 || grid[x][y + 1] == 5)) {
                    visited[x][y + 1] = true;
                    dfs(grid, x, y + 1);
                }
                if (y - 1 >= 0 && !visited[x][y - 1] && (grid[x][y - 1] == 1 || grid[x][y - 1] == 4 || grid[x][y - 1] == 6)) {
                    visited[x][y - 1] = true;
                    dfs(grid, x, y - 1);
                }
                break;
            case 2:
                if (x + 1 < m && !visited[x + 1][y] && (grid[x + 1][y] == 2 || grid[x + 1][y] == 5 || grid[x + 1][y] == 6)) {
                    visited[x + 1][y] = true;
                    dfs(grid, x + 1, y);
                }
                if (x - 1 >= 0 && !visited[x - 1][y] && (grid[x - 1][y] == 2 || grid[x - 1][y] == 3 || grid[x - 1][y] == 4)) {
                    visited[x - 1][y] = true;
                    dfs(grid, x - 1, y);
                }
                break;
            case 3:
                if (y - 1 >= 0 && !visited[x][y - 1] && (grid[x][y - 1] == 1 || grid[x][y - 1] == 4 || grid[x][y - 1] == 6)) {
                    visited[x][y - 1] = true;
                    dfs(grid, x, y - 1);
                }
                if (x + 1 < m && !visited[x + 1][y] && (grid[x + 1][y] == 2 || grid[x + 1][y] == 5 || grid[x + 1][y] == 6)) {
                    visited[x + 1][y] = true;
                    dfs(grid, x + 1, y);
                }
                break;
            case 4:
                if (x + 1 < m && !visited[x + 1][y] && (grid[x + 1][y] == 2 || grid[x + 1][y] == 5 || grid[x + 1][y] == 6)) {
                    visited[x + 1][y] = true;
                    dfs(grid, x + 1, y);
                }
                if (y + 1 < n && !visited[x][y + 1] && (grid[x][y + 1] == 1 || grid[x][y + 1] == 3 || grid[x][y + 1] == 5)) {
                    visited[x][y + 1] = true;
                    dfs(grid, x, y + 1);
                }
                break;
            case 5:
                if (x - 1 >= 0 && !visited[x - 1][y] && (grid[x - 1][y] == 2 || grid[x - 1][y] == 3 || grid[x - 1][y] == 4)) {
                    visited[x - 1][y] = true;
                    dfs(grid, x - 1, y);
                }
                if (y - 1 >= 0 && !visited[x][y - 1] && (grid[x][y - 1] == 1 || grid[x][y - 1] == 4 || grid[x][y - 1] == 6)) {
                    visited[x][y - 1] = true;
                    dfs(grid, x, y - 1);
                }
                break;
            case 6:
                if (x - 1 >= 0 && !visited[x - 1][y] && (grid[x - 1][y] == 2 || grid[x - 1][y] == 3 || grid[x - 1][y] == 4)) {
                    visited[x - 1][y] = true;
                    dfs(grid, x - 1, y);
                }
                if (y + 1 < n && !visited[x][y + 1] && (grid[x][y + 1] == 1 || grid[x][y + 1] == 3 || grid[x][y + 1] == 5)) {
                    visited[x][y + 1] = true;
                    dfs(grid, x, y + 1);
                }
                break;
        }
    }
}