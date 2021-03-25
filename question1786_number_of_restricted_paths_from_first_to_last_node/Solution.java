package question1786_number_of_restricted_paths_from_first_to_last_node;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  private static final int MOD = 1000000007;

  public int countRestrictedPaths(int n, int[][] edges) {
    Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      int node1 = edge[0] - 1, node2 = edge[1] - 1, weight = edge[2];
      Map<Integer, Integer> map1 = graph.getOrDefault(node1, new HashMap<>());
      map1.put(node2, weight);
      graph.put(node1, map1);
      Map<Integer, Integer> map2 = graph.getOrDefault(node2, new HashMap<>());
      map2.put(node1, weight);
      graph.put(node2, map2);
    }
    // 堆优化的 dijkstra
    int[] distance = new int[n];
    boolean[] visited = new boolean[n];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[n - 1] = 0;
    Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(nums -> nums[1]));
    q.add(new int[] {n - 1, 0});
    while (!q.isEmpty()) {
      int u = q.poll()[0];
      if (visited[u]) {
        continue;
      }
      visited[u] = true;
      Map<Integer, Integer> map = graph.get(u);
      if (map == null) {
        continue;
      }
      for (int v : map.keySet()) {
        distance[v] = Math.min(distance[v], distance[u] + map.get(v));
        q.add(new int[] {v, distance[v]});
      }
    }
    // dp
    int[][] indexes = new int[n][2];
    for (int i = 0; i < n; i++) {
      indexes[i] = new int[] {i, distance[i]};
    }
    Arrays.sort(indexes, Comparator.comparingInt(nums -> nums[1]));
    int[] dp = new int[n];
    dp[n - 1] = 1;
    for (int i = 0; i < n; i++) {
      int u = indexes[i][0];
      Map<Integer, Integer> map = graph.get(u);
      if (map == null) {
        continue;
      }
      for (int v : map.keySet()) {
        if (indexes[i][1] > distance[v]) {
          dp[u] += dp[v];
          dp[u] %= MOD;
        }
      }
      if (u == 0) {
        break;
      }
    }
    return dp[0];
  }

}