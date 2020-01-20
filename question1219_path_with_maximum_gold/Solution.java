package question1219_path_with_maximum_gold;

/**
 * 回溯算法。
 *
 * 时间复杂度是O(m * m * n * n)。空间复杂度是O(m * n)。
 *
 * 执行用时：18ms，击败67.53%。消耗内存：34.5MB，击败100.00%。
 */
public class Solution {
    private int result;

    private boolean[][] visited;

    private int m, n;

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int getMaximumGold(int[][] grid) {
        if (null == grid || (m = grid.length) == 0) {
            return 0;
        }
        if (null == grid[0] || (n = grid[0].length) == 0) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    visited = new boolean[m][n];
                    visited[i][j] = true;
                    dfs(i, j, grid, grid[i][j]);
                }
            }
        }
        return result;
    }

    private void dfs(int x, int y, int[][] grid, int sum) {
        result = Math.max(result, sum);
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0], newY = y + directions[i][1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY] != 0) {
                visited[newX][newY] = true;
                dfs(newX, newY, grid, sum + grid[newX][newY]);
                visited[newX][newY] = false;
            }
        }
    }
}