package question1878_get_biggest_three_rhombus_sums_in_a_grid;

import java.util.Arrays;

public class Solution {

  public int[] getBiggestThree(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int max1 = Integer.MIN_VALUE, max2 = max1, max3 = max1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // 顶点为 [i, j]
        for (int k = 0; i + k < m; k += 2) {
          // 底点为 [i + k, j]
          // 左点为 [i + k / 2, j - k / 2]，右点为 [i + k / 2, j + k / 2]
          if (j - k / 2 >= 0 && j + k / 2 < n) {
            int sum;
            if (k == 0) {
              sum = grid[i][j];
            } else {
              sum = grid[i][j] + grid[i + k][j] + grid[i + k / 2][j - k / 2] + grid[i + k / 2][j + k / 2];
              // 左上边
              for (int l = 1; l + j - k / 2 < j; l++) {
                sum += grid[i + k / 2 - l][j - k / 2 + l];
              }
              // 右上边
              for (int l = 1; l + j < j + k / 2; l++) {
                sum += grid[i + l][j + l];
              }
              // 左下边
              for (int l = 1; l + j - k / 2 < j; l++) {
                sum += grid[i + k / 2 + l][j - k / 2 + l];
              }
              // 右下边
              for (int l = 1; l + j < j + k / 2; l++) {
                sum += grid[i + k - l][j + l];
              }
            }
            if (sum > max1) {
              max3 = max2;
              max2 = max1;
              max1 = sum;
            } else if (sum < max1 && sum > max2) {
              max3 = max2;
              max2 = sum;
            } else if (sum < max2 && sum > max3) {
              max3 = sum;
            }
          }
        }
      }
    }
    if (max2 == Integer.MIN_VALUE) {
      return new int[] {max1};
    }
    if (max3 == Integer.MIN_VALUE) {
      return new int[] {max1, max2};
    }
    return new int[] {max1, max2, max3};
  }

}