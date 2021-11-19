package question2039_the_time_when_the_network_becomes_idle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public int networkBecomesIdle(int[][] edges, int[] patience) {
    Integer[] minDistance = new Integer[patience.length];
    minDistance[0] = 0;
    Set<Integer>[] graph = new HashSet[patience.length];
    for (int[] edge : edges) {
      int a = edge[0], b = edge[1];
      if (null == graph[a]) {
        graph[a] = new HashSet<>();
      }
      graph[a].add(b);
      if (null == graph[b]) {
        graph[b] = new HashSet<>();
      }
      graph[b].add(a);
    }
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    int step = 1;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        int cur = queue.poll();
        if (null != graph[cur]) {
          for (int next : graph[cur]) {
            if (null == minDistance[next]) {
              minDistance[next] = step;
              queue.add(next);
            }
          }
        }
      }
      step++;
    }
    int result = 0;
    for (int i = 1; i < patience.length; i++) {
      result = Math.max(result, (2 * minDistance[i] - 1) / patience[i] * patience[i] + 2 * minDistance[i]);
    }
    return result + 1;
  }

}