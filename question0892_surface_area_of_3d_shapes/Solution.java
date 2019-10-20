package question0892_surface_area_of_3d_shapes;

/**
 * 依次计算每个单位面积上的长方体暴露出的表面积。
 *
 * 时间复杂度是O(m * n)，其中m是矩阵grid的行数，n是矩阵grid的列数。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败92.45%。消耗内存：42.6MB，击败34.57%。
 */
public class Solution {
    public int surfaceArea(int[][] grid) {
        int m;
        if (null == grid || (m = grid.length) == 0) {
            return 0;
        }
        int n;
        if (null == grid[0] || (n = grid[0].length) == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {  //没有任何正方体
                    continue;
                }
                //下底和上顶
                result += 2;
                //左侧
                if (j == 0) {
                    result += grid[i][j];
                } else if (grid[i][j] > grid[i][j - 1]) {
                    result += grid[i][j] - grid[i][j - 1];
                }
                //右侧
                if (j == n - 1) {
                    result += grid[i][j];
                } else if (grid[i][j] > grid[i][j + 1]) {
                    result += grid[i][j] - grid[i][j + 1];
                }
                //前侧
                if (i == 0) {
                    result += grid[i][j];
                } else if (grid[i][j] > grid[i - 1][j]) {
                    result += grid[i][j] - grid[i - 1][j];
                }
                //后侧
                if (i == m - 1) {
                    result += grid[i][j];
                } else if (grid[i][j] > grid[i + 1][j]) {
                    result += grid[i][j] - grid[i + 1][j];
                }
            }
        }
        return result;
    }
}
