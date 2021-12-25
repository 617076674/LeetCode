package question2101;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  private boolean[][] graph;

  public int maximumDetonation(int[][] bombs) {
    graph = new boolean[bombs.length][bombs.length];
    for (int i = 0; i < bombs.length; i++) {
      for (int j = 0; j < bombs.length; j++) {
        if (i == j) {
          continue;
        }
        graph[i][j] = canBomb(bombs[i], bombs[j]);
      }
    }
    int result = 0;
    for (int i = 0; i < bombs.length; i++) {
      int tempResult = 0;
      Queue<Integer> queue = new LinkedList<>();
      queue.add(i);
      boolean[] visited = new boolean[bombs.length];
      visited[i] = true;
      while (!queue.isEmpty()) {
        int cur = queue.poll();
        tempResult++;
        for (int j = 0; j < graph.length; j++) {
          if (j != cur && graph[cur][j] && !visited[j]) {
            queue.add(j);
            visited[j] = true;
          }
        }
      }
      result = Math.max(result, tempResult);
    }
    return result;
  }

  private static boolean canBomb(int[] bomb1, int[] bomb2) {
    long distance2 =
        (bomb1[0] - bomb2[0]) * 1L * (bomb1[0] - bomb2[0]) + (bomb1[1] - bomb2[1]) * 1L * (bomb1[1] - bomb2[1]);
    return bomb1[2] * 1L * bomb1[2] >= distance2;
  }

}