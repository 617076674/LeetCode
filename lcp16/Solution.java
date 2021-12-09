package lcp16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Solution {

  public int maxWeight(int[][] edges, int[] value) {
    int n = value.length, e = edges.length;
    Map<Integer, Integer>[] adj = new HashMap[n];
    Arrays.sort(edges, (e1, e2) -> value[e2[0]] + value[e2[1]] - (value[e1[0]] + value[e1[1]]));
    for (int i = 0; i < e; i++) {
      int node1 = edges[i][0], node2 = edges[i][1];
      if (null == adj[node1]) {
        adj[node1] = new HashMap<>();
      }
      adj[node1].put(node2, i);
      if (null == adj[node2]) {
        adj[node2] = new HashMap<>();
      }
      adj[node2].put(node1, i);
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      Map<Integer, Integer> map = adj[i];
      if (null == map) {
        continue;
      }
      List<Integer> edgeIndexList = new ArrayList<>();
      if (map.size() * map.size() <= e) {
        // 度数小于等于 sqrt(e)，枚举所有相邻点
        for (Map.Entry<Integer, Integer> entry1 : map.entrySet()) {
          for (Map.Entry<Integer, Integer> entry2 : map.entrySet()) {
            if (!Objects.equals(entry1.getKey(), entry2.getKey()) && adj[entry1.getKey()] != null && adj[entry1.getKey()].containsKey(entry2.getKey())) {
              edgeIndexList.add(adj[entry1.getKey()].get(entry2.getKey()));
            }
          }
        }
      } else {
        // 度数大于 sqrt(E)，枚举所有的边
        for (int j = 0; j < e; j++) {
          if (map.containsKey(edges[j][0]) && map.containsKey(edges[j][1])) {
            edgeIndexList.add(j);
          }
        }
      }
      // 边的序号越小，就代表权值越大
      PriorityQueue<Integer> pq = new PriorityQueue<>((id1, id2) -> id2 - id1);
      for (int edgeIndex : edgeIndexList) {
        if (pq.size() < 3 || edgeIndex < pq.peek()) {
          pq.add(edgeIndex);
        }
        if (pq.size() > 3) {
          pq.poll();
        }
      }
      while (!pq.isEmpty()) {
        int[] edge1 = edges[pq.poll()];
        int x = edge1[0], y = edge1[1];
        int sum = value[x] + value[y] + value[i];
        for (int edgeIndex : edgeIndexList) {
          int curSum = sum;
          int[] edge2 = edges[edgeIndex];
          int z = edge2[0], w = edge2[1];
          if (z != x && z != y) {
            curSum += value[z];
          }
          if (w != x && w != y) {
            curSum += value[w];
          }
          result = Math.max(result, curSum);
        }
      }
    }
    return result;
  }

}