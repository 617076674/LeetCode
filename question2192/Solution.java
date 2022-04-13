package question2192;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public List<List<Integer>> getAncestors(int n, int[][] edges) {
    List<Set<Integer>> ancestorList = new ArrayList<>();
    List<Set<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      ancestorList.add(new HashSet<>());
      graph.add(new HashSet<>());
    }
    int[] inDegree = new int[n];
    for (int[] edge : edges) {
      int from = edge[0], to = edge[1];
      inDegree[to]++;
      graph.get(from).add(to);
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int next : graph.get(cur)) {
        ancestorList.get(next).addAll(ancestorList.get(cur));
        ancestorList.get(next).add(cur);
        inDegree[next]--;
        if (inDegree[next] == 0) {
          queue.add(next);
        }
      }
    }
    List<List<Integer>> result = new ArrayList<>();
    for (Set<Integer> ancestor : ancestorList) {
      List<Integer> list = new ArrayList<>(ancestor);
      Collections.sort(list);
      result.add(list);
    }
    return result;
  }

}