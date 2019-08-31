package question0695;

/**
 * 深搜。
 *
 * 时间复杂度和空间复杂度均是O(m * n)。
 *
 * 执行用时：9ms，击败41.26%。消耗内存：48.6MB，击败64.55%。
 */
public class Solution {
    private int m;

    private int n;

    private boolean[][] visited;

    private int count;

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        int result = 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j, grid);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    private void dfs(int x, int y, int[][] grid) {
        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1 && !visited[newX][newY]) {
                dfs(newX, newY, grid);
            }
        }
    }
}
