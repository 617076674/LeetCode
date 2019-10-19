package question0883_projection_area_of_3d_shapes;

/**
 * 时间复杂度是O(m * n)，其中m为矩阵的行数，n为矩阵的列数。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败99.56%。消耗内存：42.5MB，击败22.22%。
 */
public class Solution {
    public int projectionArea(int[][] grid) {
        int m;
        if (grid == null || (m = grid.length) == 0) {
            return 0;
        }
        int n;
        if (grid[0] == null || (n = grid[0].length) == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            int height = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    result++;
                }
                height = Math.max(height, grid[i][j]);
            }
            result += height;
        }
        for (int i = 0; i < n; i++) {
            int height = 0;
            for (int j = 0; j < m; j++) {
                height = Math.max(height, grid[j][i]);
            }
            result += height;
        }
        return result;
    }
}
