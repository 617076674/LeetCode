package question0200_number_of_islands;

/**
 * 图的深度优先遍历求连通分量。
 *
 * 时间复杂度和空间复杂度均是O(m * n)，其中m为grid数组的行数，n是grid数组的列数。
 *
 * 执行用时：6ms，击败30.44%。消耗内存：42.8MB，击败47.05%。
 */
public class Solution1 {
    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int m, n;

    public int numIslands(char[][] grid) {
        if (null == grid || (m = grid.length) == 0) {
            return 0;
        }
        if (null == grid[0] || (n = grid[0].length) == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';   //将遍历过的节点标记为'0'，省去了一个visited数组的开销
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0], newY = y + direction[i][1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }
    }
}