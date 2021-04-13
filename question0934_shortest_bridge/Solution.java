package question0934_shortest_bridge;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public int shortestBridge(int[][] A) {
    int rows = A.length, cols = A[0].length;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] colors = new int[rows][cols];
    int curColor = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (colors[i][j] == 0 && A[i][j] == 1) {
          LinkedList<Integer> stack = new LinkedList<>();
          stack.addLast(i * cols + j);
          colors[i][j] = ++curColor;
          while (!stack.isEmpty()) {
            int cur = stack.pollLast(), curR = cur / cols, curC = cur % cols;
            for (int[] direction : directions) {
              int nextR = curR + direction[0], nextC = curC + direction[1];
              if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && colors[nextR][nextC] == 0 && A[nextR][nextC] == 1) {
                colors[nextR][nextC] = curColor;
                stack.addLast(nextR * cols + nextC);
              }
            }
          }
        }
      }
    }
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> target = new HashSet<>();
    for (int r = 0; r < rows; ++r) {
      for (int c = 0; c < cols; ++c) {
        if (colors[r][c] == 1) {
          queue.add(r * cols + c);
        } else if (colors[r][c] == 2) {
          target.add(r * cols + c);
        }
      }
    }
    int result = 0;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        int cur = queue.poll();
        if (target.contains(cur)) {
          return result - 1;
        }
        int curR = cur / cols, curC = cur % cols;
        for (int[] direction : directions) {
          int nextR = curR + direction[0], nextC = curC + direction[1];
          if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && colors[nextR][nextC] != 1) {
            colors[nextR][nextC] = 1;
            queue.add(nextR * cols + nextC);
          }
        }
      }
      result++;
    }
    return result;
  }

}