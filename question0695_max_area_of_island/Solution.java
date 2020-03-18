package question0695_max_area_of_island;

/**
 * 深搜。
 *
 * 时间复杂度是O(m * n)。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败81.96%。消耗内存：41.3MB，击败91.22%。
 */
public class Solution {
    private int m, n, count;

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        if (null == grid || (m = grid.length) == 0) {
            return 0;
        }
        if (null == grid[0] || (n = grid[0].length) == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    dfs(i, j, grid);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    private void dfs(int x, int y, int[][] grid) {
        grid[x][y] = -1;
        count++;
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0], newY = y + directions[i][1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1 && grid[newX][newY] != -1) {
                dfs(newX, newY, grid);
            }
        }
    }
}