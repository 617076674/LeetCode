package question0815_bus_routes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  private boolean[][] graph;

  public int numBusesToDestination(int[][] routes, int source, int target) {
    if (source == target) {
      return 0;
    }
    Map<Integer, List<Integer>> station2BusList = new HashMap<>();
    for (int i = 0; i < routes.length; i++) {
      for (int j = 0; j < routes[i].length; j++) {
        List<Integer> list = station2BusList.get(routes[i][j]);
        if (null == list) {
          list = new ArrayList<>();
          list.add(i);
          station2BusList.put(routes[i][j], list);
        } else {
          list.add(i);
        }
      }
    }
    Map<Integer, Set<Integer>> station2BusSet = new HashMap<>();
    for (Map.Entry<Integer, List<Integer>> entry : station2BusList.entrySet()) {
      station2BusSet.put(entry.getKey(), new HashSet<>(entry.getValue()));
    }
    graph = new boolean[routes.length][routes.length];
    for (List<Integer> list : station2BusList.values()) {
      for (int i = 0; i < list.size(); i++) {
        for (int j = i + 1; j < list.size(); j++) {
          graph[list.get(i)][list.get(j)] = graph[list.get(j)][list.get(i)] = true;
        }
      }
    }
    List<Integer> beginList = station2BusList.get(source);
    if (null == beginList) {
      return -1;
    }
    List<Integer> endList = station2BusList.get(target);
    if (null == endList) {
      return -1;
    }
    Set<Integer> endSet = new HashSet<>(endList);
    int result = Integer.MAX_VALUE;
    for (int begin : beginList) {
      int[] pre = new int[graph.length];
      int temp = minBus(begin, endSet, pre);
      if (temp == Integer.MAX_VALUE) {
        continue;
      }
      List<List<Integer>> pathList = getPath(endSet, pre);
      int copyTemp = temp;
      for (List<Integer> path : pathList) {
        if (path.isEmpty()) {
          return 1;
        }
        int first = path.get(path.size() - 1);
        Set<Integer> busSet = station2BusSet.get(source);
        if (busSet.contains(first)) {
          copyTemp = temp;
        } else {
          copyTemp = temp + 1;
        }
      }
      result = Math.min(result, copyTemp);
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  private List<List<Integer>> getPath(Set<Integer> endSet, int[] pre) {
    List<List<Integer>> result = new ArrayList<>();
    for (Integer end : endSet) {
      List<Integer> path = new ArrayList<>();
      int cur = end;
      while (pre[cur] != -1 && pre[cur] != cur) {
        path.add(cur);
        cur = pre[cur];
      }
      result.add(path);
    }
    return result;
  }

  private int minBus(int begin, Set<Integer> endSet, int[] pre) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(begin);
    int step = 0;
    boolean[] visited = new boolean[graph.length];
    visited[begin] = true;
    pre[begin] = -1;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        int cur = queue.poll();
        if (endSet.contains(cur)) {
          return step;
        }
        for (int j = 0; j < graph.length; j++) {
          if (graph[cur][j] && !visited[j]) {
            queue.add(j);
            pre[j] = cur;
            visited[j] = true;
          }
        }
      }
      step++;
    }
    return Integer.MAX_VALUE;
  }

}