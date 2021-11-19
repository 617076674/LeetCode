package question0882_reachable_nodes_in_subdivided_graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

  private static class Node {

    int index, dist;

    Node(int n, int d) {
      index = n;
      dist = d;
    }

  }

  public int reachableNodes(int[][] edges, int maxMovies, int n) {
    Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      int u = edge[0], v = edge[1], w = edge[2];
      graph.computeIfAbsent(u, x -> new HashMap<>()).put(v, w);
      graph.computeIfAbsent(v, x -> new HashMap<>()).put(u, w);
    }

    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
    pq.offer(new Node(0, 0));

    Map<Integer, Integer> dist = new HashMap<>();
    dist.put(0, 0);
    Map<Integer, Integer> used = new HashMap<>();
    int result = 0;
    while (!pq.isEmpty()) {
      Node anode = pq.poll();
      int node = anode.index;
      int d = anode.dist;

      if (d > dist.getOrDefault(node, 0)) {
        continue;
      }
      result++;
      if (!graph.containsKey(node)) {
        continue;
      }
      for (int nei : graph.get(node).keySet()) {
        int weight = graph.get(node).get(nei);
        int v = Math.min(weight, maxMovies - d);
        used.put(n * node + nei, v);
        int d2 = d + weight + 1;
        if (d2 < dist.getOrDefault(nei, maxMovies + 1)) {
          pq.offer(new Node(nei, d2));
          dist.put(nei, d2);
        }
      }
    }
    for (int[] edge : edges) {
      result += Math.min(edge[2], used.getOrDefault(edge[0] * n + edge[1], 0) +
          used.getOrDefault(edge[1] * n + edge[0], 0));
    }
    return result;
  }

}