package question0980_unique_paths_iii;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private int m, n, begin, end;

  private int result;

  private int terminatedStatus;

  public int uniquePathsIII(int[][] grid) {
    m = grid.length;
    n = grid[0].length;
    terminatedStatus = (1 << (m * n)) - 1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          begin = i * n + j;
        } else if (grid[i][j] == 2) {
          end = i * n + j;
        } else if (grid[i][j] == -1) {
          int index = position2Index(i, j);
          terminatedStatus ^= (1 << index);
        }
      }
    }
    List<Integer> path = new ArrayList<>();
    path.add(begin);
    dfs(grid, begin, 0, path);
    return result;
  }

  public static void main(String[] args) {
    int[][] grid = {{0,1},{2,0}};
    System.out.println(new Solution().uniquePathsIII(grid));
  }

  private void dfs(int[][] grid, int cur, int status, List<Integer> path) {
    if (status == terminatedStatus) {
      if (cur == end) {
        result++;
      }
      return;
    }
    status |= (1 << cur);
    int x = cur / n, y = cur % n;
    for (int[] direction : directions) {
      int nextX = direction[0] + x, nextY = direction[1] + y;
      if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] != -1) {
        int index = position2Index(nextX, nextY);
        if (((status >> index) & 1) == 0) {
          status ^= (1 << index);
          path.add(index);
          dfs(grid, index, status, path);
          path.remove(path.size() - 1);
          status ^= (1 << index);
        }
      }
    }
  }

  private int position2Index(int x, int y) {
    return x * n + y;
  }

}