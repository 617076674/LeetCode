package question1192_critical_connections_in_a_network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1、所有在环上的边都不是 critical connection。
 * 2、所有不在环上的边都是 critical connection。
 */
public class Solution {

  private Set<Integer>[] graph;

  private List<List<Integer>> result = new ArrayList<>();

  private int[] timeStamps;

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    graph = new HashSet[n];
    for (List<Integer> connection : connections) {
      int node1 = connection.get(0), node2 = connection.get(1);
      if (graph[node1] == null) {
        graph[node1] = new HashSet<>();
      }
      graph[node1].add(node2);
      if (graph[node2] == null) {
        graph[node2] = new HashSet<>();
      }
      graph[node2].add(node1);
    }
    timeStamps = new int[n];
    Arrays.fill(timeStamps, -1);
    dfs(0, -1, 0);
    return result;
  }

  private int dfs(int cur, int parent, int timeStamp) {
    timeStamps[cur] = timeStamp;
    for (int next : graph[cur]) {
      if (next == parent) {
        continue;
      } else if (timeStamps[next] == -1) {
        timeStamps[cur] = Math.min(timeStamps[cur], dfs(next, cur, timeStamp + 1));
      } else {
        timeStamps[cur] = Math.min(timeStamps[cur], timeStamps[next]);
      }
    }
    if (timeStamps[cur] == timeStamp && cur != 0) {
      List<Integer> edge = new ArrayList<>();
      edge.add(cur);
      edge.add(parent);
      result.add(edge);
    }
    return timeStamps[cur];
  }

}