package question2065_maximum_path_quality_of_a_graph;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  private Integer[][] graph;

  private Set<Integer>[] nextNode;

  private boolean[] visited;

  private int result;

  private int maxTime;

  public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
    graph = new Integer[values.length][values.length];
    nextNode = new HashSet[values.length];
    for (int[] edge : edges) {
      graph[edge[0]][edge[1]] = graph[edge[1]][edge[0]] = edge[2];
      if (null == nextNode[edge[0]]) {
        nextNode[edge[0]] = new HashSet<>();
      }
      nextNode[edge[0]].add(edge[1]);
      if (null == nextNode[edge[1]]) {
        nextNode[edge[1]] = new HashSet<>();
      }
      nextNode[edge[1]].add(edge[0]);
    }
    visited = new boolean[values.length];
    this.maxTime = maxTime;
    visited[0] = true;
    dfs(values, 0, 0, values[0]);
    return result;
  }

  private void dfs(int[] values, int curTime, int cur, int curValue) {
    if (curTime > maxTime) {
      return;
    }
    if (cur == 0) {
      result = Math.max(result, curValue);
    }
    if (null == nextNode[cur]) {
      return;
    }
    for (int next : nextNode[cur]) {
      if (visited[next]) {
        dfs(values, curTime + graph[cur][next], next, curValue);
      } else {
        visited[next] = true;
        dfs(values, curTime + graph[cur][next], next, curValue + values[next]);
        visited[next] = false;
      }
    }
  }

}