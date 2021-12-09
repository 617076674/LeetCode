package question2097;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

  private Map<Integer, LinkedList<Integer>> graph = new HashMap<>();

  private int[][] result;

  private int index;

  public int[][] validArrangement(int[][] pairs) {
    Map<Integer, Integer> inDegree = new HashMap<>(), outDegree = new HashMap<>();
    for (int[] pair : pairs) {
      int from = pair[0], to = pair[1];
      LinkedList<Integer> set = graph.get(from);
      if (set == null) {
        set = new LinkedList<>();
        set.add(to);
        graph.put(from, set);
      } else {
        set.add(to);
      }
      inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);
      outDegree.put(from, outDegree.getOrDefault(from, 0) + 1);
    }
    int start = pairs[0][0];
    for (Map.Entry<Integer, Integer> entry : outDegree.entrySet()) {
      if (entry.getValue() == inDegree.getOrDefault(entry.getKey(), 0) + 1) {
        start = entry.getKey();
        break;
      }
    }
    result = new int[pairs.length][2];
    index = pairs.length - 1;
    dfs(start);
    return result;
  }

  /**
   * Hierholzer 算法求解欧拉通路
   */
  private void dfs(int cur) {
    while (true) {
      LinkedList<Integer> linkedList = graph.get(cur);
      if (null == linkedList || linkedList.isEmpty()) {
        return;
      }
      int next = linkedList.pollLast();
      dfs(next);
      result[index--] = new int[] {cur, next};
    }
  }

}