package question0675_cut_off_trees_for_golf_event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  private int m, n;

  private static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public int cutOffTree(List<List<Integer>> forest) {
    m = forest.size();
    n = forest.get(0).size();
    List<int[]> positionList = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (forest.get(i).get(j) > 1) {
          positionList.add(new int[] {i, j});
        }
      }
    }
    Collections.sort(positionList, Comparator.comparingInt(p -> forest.get(p[0]).get(p[1])));
    int[] start = {0, 0};
    int result = 0;
    for (int[] position : positionList) {
      int step = minSteps(forest, start, position);
      if (step == -1) {
        return -1;
      }
      result += step;
      start = position;
    }
    return result;
  }

  private int minSteps(List<List<Integer>> forest, int[] start, int[] end) {
    boolean[][] visited = new boolean[m][n];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(start);
    visited[start[0]][start[1]] = true;
    int step = 0;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        int[] cur = queue.poll();
        if (cur[0] == end[0] && cur[1] == end[1]) {
          return step;
        }
        for (int[] direction : directions) {
          int nextX = cur[0] + direction[0], nextY = cur[1] + direction[1];
          if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
              && forest.get(nextX).get(nextY) != 0 && !visited[nextX][nextY]) {
            queue.add(new int[] {nextX, nextY});
            visited[nextX][nextY] = true;
          }
        }
      }
      step++;
    }
    return -1;
  }

}