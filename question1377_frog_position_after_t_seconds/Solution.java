package question1377_frog_position_after_t_seconds;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

  private static class StatusNode {
    double possible;
    int index;

    public StatusNode(double possible, int index) {
      this.possible = possible;
      this.index = index;
    }
  }

  private Set<Integer>[] graph;

  private boolean[] visited;

  public double frogPosition(int n, int[][] edges, int t, int target) {
    graph = new HashSet[n + 1];
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new HashSet<>();
    }
    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }
    visited = new boolean[n + 1];
    Queue<StatusNode> queue = new LinkedList<>();
    queue.add(new StatusNode(1.0, 1));
    visited[1] = true;
    while (!queue.isEmpty() && t >= 0) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        StatusNode cur = queue.poll();
        if (t == 0 && target == cur.index) {
          return cur.possible;
        }
        int countNext = 0;
        for (int next : graph[cur.index]) {
          if (!visited[next]) {
            countNext++;
          }
        }
        if (countNext == 0) {
          queue.add(new StatusNode(cur.possible, cur.index));
          continue;
        }
        for (int next : graph[cur.index]) {
          if (!visited[next]) {
            visited[next] = true;
            queue.add(new StatusNode(1.0 / countNext * cur.possible, next));
          }
        }
      }
      t--;
    }
    return 0.0;
  }

}