package question0200;

/**
 * 图的深度优先遍历求连通分量。
 *
 * 时间复杂度和空间复杂度均是O(m * n)，其中m为grid数组的行数，n是grid数组的列数。
 *
 * 执行用时：6ms，击败30.44%。消耗内存：42.8MB，击败47.05%。
 */
public class Solution1 {
    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
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

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';   //将遍历过的节点标记为'0'，省去了一个visited数组的开销
        for (int k = 0; k < 4; k++) {
            int newX = i + direction[k][0];
            int newY = j + direction[k][1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }
    }
}