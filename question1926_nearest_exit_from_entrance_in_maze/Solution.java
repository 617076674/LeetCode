package question1926_nearest_exit_from_entrance_in_maze;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  private int m, n;

  public int nearestExit(char[][] maze, int[] entrance) {
    m = maze.length;
    n = maze[0].length;
    Queue<int[]> queue = new LinkedList<>();
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited = new boolean[m][n];
    visited[entrance[0]][entrance[1]] = true;
    queue.add(entrance);
    int step = 0;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        int[] cur = queue.poll();
        if (check(cur) && step > 0) {
          return step;
        }
        for (int[] direction : directions) {
          int[] next = new int[] {cur[0] + direction[0], cur[1] + direction[1]};
          if (next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n && !visited[next[0]][next[1]] && maze[next[0]][next[1]] == '.') {
            visited[next[0]][next[1]] = true;
            queue.add(next);
          }
        }
      }
      step++;
    }
    return -1;
  }

  private boolean check(int[] entrance) {
    return entrance[0] == 0 || entrance[0] == m - 1 || entrance[1] == 0 || entrance[1] == n - 1;
  }

}