package question0750_number_of_corner_rectangles;

/**
 * 时间复杂度是 O(m * m * n)，其中 m 为矩阵 grid 的行数，n 为矩阵 grid 的列数。空间复杂度是 O(1)。
 *
 * 执行用时：161ms，击败29.69%。消耗内存：48.6MB，击败100.00%。
 */
public class Solution {
    public int countCornerRectangles(int[][] grid) {
        int m;
        if (null == grid || (m = grid.length) <= 1) {
            return 0;
        }
        int n;
        if (null == grid[0] || (n = grid[0].length) == 1) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int cols = 0;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] == grid[j][k] && grid[i][k] == 1) {
                        cols++;
                    }
                }
                result += cols * (cols - 1) / 2;
            }
        }
        return result;
    }
}