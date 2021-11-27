package question1761;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

  public int minTrioDegree(int n, int[][] edges) {
    Set<Integer>[] graph = new HashSet[n + 1];
    int[] degree = new int[n + 1];
    for (int[] edge : edges) {
      degree[edge[0]]++;
      degree[edge[1]]++;
    }
    for (int[] edge : edges) {
      int from, to;
      if (degree[edge[0]] == degree[edge[1]]) {
        if (edge[0] < edge[1]) {
          from = edge[0];
          to = edge[1];
        } else {
          from = edge[1];
          to = edge[0];
        }
      } else if (degree[edge[0]] > degree[edge[1]]) {
        from = edge[1];
        to = edge[0];
      } else {
        from = edge[0];
        to = edge[1];
      }
      if (null == graph[from]) {
        graph[from] = new HashSet<>();
      }
      graph[from].add(to);
    }
    int result = -1;
    for (int i = 1; i <= n; i++) {
      if (degree[i] < 2 || null == graph[i]) {
        continue;
      }
      for (int j : graph[i]) {
        if (degree[j] < 2 || null == graph[j]) {
          continue;
        }
        for (int k : graph[j]) {
          if (degree[k] < 2) {
            continue;
          }
          if ((null != graph[k] && graph[k].contains(i)) || (null != graph[i] && graph[i].contains(k))) {
            int temp = degree[i] + degree[j] + degree[k] - 6;
            if (result == -1) {
              result = temp;
            } else {
              result = Math.min(result, temp);
            }
          }
        }
      }
    }
    return result;
  }

}
