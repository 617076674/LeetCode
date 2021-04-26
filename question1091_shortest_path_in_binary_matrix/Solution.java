package question1091_shortest_path_in_binary_matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid[0][0] == 1) {
      return -1;
    }
    int[][] directions =
        {{-1, -1}, {-1, 0}, {-1, 1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {0, -1}};
    int n = grid.length, result = 1;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    grid[0][0] = -1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int cur = queue.poll();
        if (cur == n * n - 1) {
          return result;
        }
        int row = cur / n, col = cur % n;
        for (int[] direction : directions) {
          int nextRow = direction[0] + row, nextCol = direction[1] + col;
          if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 0) {
            grid[nextRow][nextCol] = -1;
            queue.add(nextRow * n + nextCol);
          }
        }
      }
      result++;
    }
    return -1;
  }

}