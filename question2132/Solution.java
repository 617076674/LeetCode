package question2132;

public class Solution {

  public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
    int m = grid.length;
    int n = grid[0].length;
    // sums[i][j] 存储的是左上角为 (0, 0)，右下角为 (i - 1, j - 1) 的矩形元素之和
    int[][] sums = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + grid[i - 1][j - 1];
      }
    }
    // diff[i][j] 是二维差分
    int[][] diff = new int[m + 1][n + 1];
    for (int i = stampHeight - 1; i < m; i++) {
      for (int j = stampWidth - 1; j < n; j++) {
        if (sums[i + 1][j + 1] - sums[i - stampHeight + 1][j + 1] - sums[i + 1][j - stampWidth + 1]
            + sums[i - stampHeight + 1][j - stampWidth + 1] == 0) {
          diff[i - stampHeight + 1][j - stampWidth + 1]++;
          diff[i + 1][j + 1]++;
          diff[i - stampHeight + 1][j + 1]--;
          diff[i + 1][j - stampWidth + 1]--;
        }
      }
    }
    // diffSum 存储的是左上角为 (0, 0)，右下角为 (i - 1, j - 1) 的 diff 元素之和
    int[][] diffSum = new int[m + 2][n + 2];
    for (int i = 1; i < m + 2; i++) {
      for (int j = 1; j < n + 2; j++) {
        diffSum[i][j] = diffSum[i - 1][j] + diffSum[i][j - 1] - diffSum[i - 1][j - 1] + diff[i - 1][j - 1];
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          continue;
        }
        if (diffSum[i + 1][j + 1] == 0) {
          return false;
        }
      }
    }
    return true;
  }

}