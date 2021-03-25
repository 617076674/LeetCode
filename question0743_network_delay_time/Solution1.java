package question0743_network_delay_time;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {

  private int[][] graph;

  private Map<Integer, Integer> node2Distance = new HashMap<>();

  public int networkDelayTime(int[][] times, int n, int k) {
    graph = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(graph[i], -1);
    }
    for (int[] time : times) {
      int source = time[0] - 1, destination = time[1] - 1;
      graph[source][destination] = time[2];
    }
    dfs(k - 1, 0);
    if (node2Distance.size() < n) {
      return -1;
    }
    int result = 0;
    for (int distance : node2Distance.values()) {
      result = Math.max(result, distance);
    }
    return result;
  }

  private void dfs(int now, int distance) {
    Integer temp = node2Distance.get(now);
    if (null != temp && distance >= temp) {
      return;
    }
    node2Distance.put(now, distance);
    for (int i = 0; i < graph.length; i++) {
      if (graph[now][i] != -1) {
        dfs(i, distance + graph[now][i]);
      }
    }
  }

}