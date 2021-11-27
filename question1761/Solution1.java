package question1761;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

  public int minTrioDegree(int n, int[][] edges) {
    Set<Integer>[] graph = new HashSet[n + 1];
    int[] degree = new int[n + 1];
    for (int[] edge : edges) {
      if (null == graph[edge[0]]) {
        graph[edge[0]] = new HashSet<>();
      }
      graph[edge[0]].add(edge[1]);
      if (null == graph[edge[1]]) {
        graph[edge[1]] = new HashSet<>();
      }
      graph[edge[1]].add(edge[0]);
      degree[edge[0]]++;
      degree[edge[1]]++;
    }
    int result = -1;
    for (int i = 1; i <= n; i++) {
      if (degree[i] < 2) {
        continue;
      }
      for (int j : graph[i]) {
        if (degree[j] < 2) {
          continue;
        }
        for (int k : graph[j]) {
          if (degree[k] < 2 || !graph[i].contains(k)) {
            continue;
          }
          int temp = degree[i] + degree[j] + degree[k] - 6;
          if (result == -1) {
            result = temp;
          } else {
            result = Math.min(result, temp);
          }
        }
      }
    }
    return result;
  }

}