package question1210_minimum_moves_to_reach_target_with_rotations;

public class Solution {

  private int n;

  private Integer[][] memo;

  private boolean[][] visited;

  public int minimumMoves(int[][] grid) {
    n = grid.length;
    memo = new Integer[n * n][2];
    visited = new boolean[n * n][2];
    int result = minimumMovesHelper(grid, 1, 1);
    return result >= Integer.MAX_VALUE / 2 ? -1 : result;
  }

  private int minimumMovesHelper(int[][] grid, int head, int isLevel) {
    if (head == n * n - 1 && isLevel == 1) {
      return 0;
    }
    if (memo[head][isLevel] != null) {
      return memo[head][isLevel];
    }
    visited[head][isLevel] = true;
    int result = Integer.MAX_VALUE / 2, curX = head / n, curY = head % n;
    if (isLevel == 1) {
      // 当前蛇处于水平状态
      if (curY + 1 < n && grid[curX][curY + 1] == 0) {
        // 1. 向右移动
        if (!visited[head + 1][1]) {
          result = Math.min(result, 1 + minimumMovesHelper(grid, head + 1, 1));
        }
      }
      if (curX + 1 < n && grid[curX + 1][curY] == 0 && grid[curX + 1][curY - 1] == 0) {
        // 2. 向下移动
        if (!visited[head + n][1]) {
          result = Math.min(result, 1 + minimumMovesHelper(grid, head + n, 1));
        }
        // 3. 顺时针旋转
        if (!visited[head + n - 1][0]) {
          result = Math.min(result, 1 + minimumMovesHelper(grid, head + n - 1, 0));
        }
      }
    } else {
      // 当前蛇处于竖直状态
      if (curX + 1 < n && grid[curX + 1][curY] == 0) {
        // 1. 向下移动
        if (!visited[head + n][0]) {
          result = Math.min(result, 1 + minimumMovesHelper(grid, head + n, 0));
        }
      }
      if (curY + 1 < n && grid[curX][curY + 1] == 0 && grid[curX - 1][curY + 1] == 0) {
        // 2. 向右移动
        if (!visited[head + 1][0]) {
          result = Math.min(result, 1 + minimumMovesHelper(grid, head + 1, 0));
        }
        // 3. 逆时针旋转
        if (!visited[head - n + 1][1]) {
          result = Math.min(result, 1 + minimumMovesHelper(grid, head - n + 1, 1));
        }
      }
    }
    memo[head][isLevel] = result;
    visited[head][isLevel] = false;
    return result;
  }

}