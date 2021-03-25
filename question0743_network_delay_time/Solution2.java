package question0743_network_delay_time;

import java.util.Arrays;

public class Solution2 {

  private int[][] graph;

  private boolean[] visited;

  private int[] distance;

  private int begin;

  public int networkDelayTime(int[][] times, int n, int k) {
    graph = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(graph[i], -1);
    }
    for (int[] time : times) {
      int source = time[0] - 1, destination = time[1] - 1;
      graph[source][destination] = time[2];
    }
    distance = new int[n];
    visited = new boolean[n];
    begin = k - 1;
    dijkstra();
    int result = 0;
    for (int value : distance) {
      result = Math.max(result, value);
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  private void dijkstra() {
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[begin] = 0;
    for (int i = 0; i < distance.length - 1; i++) {
      int u = -1, min = Integer.MAX_VALUE;
      for (int j = 0; j < distance.length; j++) {
        if (!visited[j] && distance[j] < min) {
          min = distance[j];
          u = j;
        }
      }
      if (u == -1) {
        return;
      }
      visited[u] = true;
      for (int v = 0; v < graph.length; v++) {
        if (!visited[v] && graph[u][v] != -1) {
          distance[v] = Math.min(distance[v], distance[u] + graph[u][v]);
        }
      }
    }
  }

}
