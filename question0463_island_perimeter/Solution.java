package question0463_island_perimeter;

/**
 * 遍历为1的每个格子，判断其4条边是否属于边界即可。
 *
 * 时间复杂度是O(m * n)，其中m为矩阵的行数，n为矩阵的列数。空间复杂度是O(1)。
 *
 * 执行用时：16ms，击败77.18%。消耗内存：70.1MB，击败74.30%。
 */
public class Solution {

  public int islandPerimeter(int[][] grid) {
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
        if (grid[i][j] == 1) {
          if (i + 1 > m - 1 || grid[i + 1][j] == 0) {
            result++;
          }
          if (i - 1 < 0 || grid[i - 1][j] == 0) {
            result++;
          }
          if (j - 1 < 0 || grid[i][j - 1] == 0) {
            result++;
          }
          if (j + 1 > n - 1 || grid[i][j + 1] == 0) {
            result++;
          }
        }
      }
    }
    return result;
  }

}