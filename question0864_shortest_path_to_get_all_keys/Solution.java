package question0864_shortest_path_to_get_all_keys;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public int shortestPathAllKeys(String[] grid) {
    int m = grid.length, n = grid[0].length();
    int[] source = null;
    int keys = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        char c = grid[i].charAt(j);
        if (c == '@') {
          source = new int[] {i, j, 0};
        } else if (c >= 'a' && c <= 'f') {
          keys++;
        }
      }
    }
    boolean[][][] visited = new boolean[m][n][1 << keys];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(source);
    visited[source[0]][source[1]][0] = true;
    int result = 0;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        int[] cur = queue.poll();
        if (cur[2] == (1 << keys) - 1) {
          return result;
        }
        for (int[] direction : directions) {
          int nextRow = direction[0] + cur[0], nextCol = direction[1] + cur[1];
          if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
            char c = grid[nextRow].charAt(nextCol);
            if (c == '#' || ((cur[2] & (1 << (c - 'A'))) == 0) && (c >= 'A' && c <= 'F')) {
              continue;
            }
            int nextStatus = cur[2];
            if (c >= 'a' && c <= 'f') {
              nextStatus |= (1 << (c - 'a'));
            }
            if (!visited[nextRow][nextCol][nextStatus]) {
              queue.add(new int[] {nextRow, nextCol, nextStatus});
              visited[nextRow][nextCol][nextStatus] = true;
            }
          }
        }
      }
      result++;
    }
    return -1;
  }

}