package contest_12_11;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public int[] loudAndRich(int[][] richer, int[] quiet) {
    int n = quiet.length;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      result[i] = i;
    }
    boolean[][] graph = new boolean[n][n];
    int[] inDegree = new int[n];
    for (int[] relation : richer) {
      inDegree[relation[1]]++;
      graph[relation[0]][relation[1]] = true;
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int i = 0; i < n; i++) {
        if (graph[cur][i]) {
          inDegree[i]--;
          if (quiet[result[cur]] < quiet[result[i]]) {
            result[i] = result[cur];
          }
          if (inDegree[i] == 0) {
              queue.add(i);
          }
        }
      }
    }
    return result;
  }

}