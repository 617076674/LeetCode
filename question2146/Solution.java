package question2146;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Solution {

  private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
    int m = grid.length;
    int n = grid[0].length;
    List<List<Integer>> result = new ArrayList<>();
    Queue<List<Integer>> queue = new LinkedList<>();
    boolean[][] visited = new boolean[m][n];
    int[][] distance = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(distance[i], Integer.MAX_VALUE / 2);
    }
    distance[start[0]][start[1]] = 0;
    visited[start[0]][start[1]] = true;
    List<Integer> first = new ArrayList<>();
    first.add(start[0]);
    first.add(start[1]);
    if (grid[start[0]][start[1]] >= pricing[0] && grid[start[0]][start[1]] <= pricing[1]) {
      result.add(first);
    }
    queue.add(first);
    while (!queue.isEmpty() && result.size() < k) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        List<Integer> cur = queue.poll();
        for (int[] direction : DIRECTIONS) {
          int nextX = cur.get(0) + direction[0];
          int nextY = cur.get(1) + direction[1];
          if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] != 0 && !visited[nextX][nextY]) {
            visited[nextX][nextY] = true;
            distance[nextX][nextY] = distance[cur.get(0)][cur.get(1)] + 1;
            List<Integer> list = new ArrayList<>();
            list.add(nextX);
            list.add(nextY);
            queue.add(list);
            if (grid[nextX][nextY] >= pricing[0] && grid[nextX][nextY] <= pricing[1]) {
              result.add(list);
            }
          }
        }
      }
    }
    Collections.sort(result, (list1, list2) -> {
      if (distance[list1.get(0)][list1.get(1)] == distance[list2.get(0)][list2.get(1)]) {
        if (grid[list1.get(0)][list1.get(1)] == grid[list2.get(0)][list2.get(1)]) {
          if (Objects.equals(list1.get(0), list2.get(0))) {
            return list1.get(1) - list2.get(1);
          }
          return list1.get(0) - list2.get(0);
        }
        return grid[list1.get(0)][list1.get(1)] - grid[list2.get(0)][list2.get(1)];
      }
      return distance[list1.get(0)][list1.get(1)] - distance[list2.get(0)][list2.get(1)];
    });
    if (k >= result.size()) {
      return result;
    }
    return result.subList(0, k);
  }

}