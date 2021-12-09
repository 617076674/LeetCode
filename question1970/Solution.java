package question1970;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  private int row;

  private int col;

  private int[][] cells;

  public static void main(String[] args) {
    int row = 6;
    int col = 2;
    int[][] cells = {{4,2},{6,2},{2,1},{4,1},{6,1},{3,1},{2,2},{3,2},{1,1},{5,1},{5,2},{1,2}};
    System.out.println(new Solution().latestDayToCross(row, col, cells));
  }

  public int latestDayToCross(int row, int col, int[][] cells) {
    this.row = row;
    this.col = col;
    this.cells = cells;
    int left = 0, right = cells.length - 1;
    while (left < right) {
      if (left + 1 == right) {
        if (check(right)) {
          return right + 1;
        }
        if (check(left)) {
          return left + 1;
        }
        return 0;
      }
      int mid = left + ((right - left) >> 1);
      if (check(mid)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    if (check(left)) {
      return left + 1;
    }
    if (check(right)) {
      return right + 1;
    }
    return 0;
  }

  // cells 数组 [0, index] 范围内变成水域 1
  private boolean check(int index) {
    int[][] grid = new int[row][col];
    for (int i = 0; i <= index; i++) {
      grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
    }
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[row][col];
    for (int j = 0; j < col; j++) {
      if (grid[0][j] == 0) {
        queue.add(new int[] {0, j});
        visited[0][j] = true;
      }
    }
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      if (cur[0] == row - 1) {
        return true;
      }
      for (int[] direction : DIRECTIONS) {
        int[] next = new int[] {cur[0] + direction[0], cur[1] + direction[1]};
        if (next[0] >= 0 && next[0] < row && next[1] >= 0 && next[1] < col && !visited[next[0]][next[1]] && grid[next[0]][next[1]] == 0) {
          queue.add(next);
          visited[next[0]][next[1]] = true;
        }
      }
    }
    return false;
  }

}