package question1719_number_of_ways_to_reconstruct_a_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  private int result = 1;

  private Set<Integer> nodeSet = new HashSet<>();

  private List<Integer>[] relative = new ArrayList[501];

  private boolean[][] isRelative = new boolean[501][501];

  private List<Integer>[] children = new ArrayList[501];

  private Set<Integer> visited = new HashSet<>();

  public int checkWays(int[][] pairs) {
    for (int[] pair : pairs) {
      nodeSet.add(pair[0]);
      nodeSet.add(pair[1]);
      if (null == relative[pair[0]]) {
        relative[pair[0]] = new ArrayList<>();
      }
      relative[pair[0]].add(pair[1]);
      if (null == relative[pair[1]]) {
        relative[pair[1]] = new ArrayList<>();
      }
      relative[pair[1]].add(pair[0]);
      isRelative[pair[0]][pair[1]] = isRelative[pair[1]][pair[0]] = true;
    }
    List<Integer> nodes = new ArrayList<>(nodeSet);
    Collections.sort(nodes, Comparator.comparingInt(node -> relative[node].size()));
    int root = -1;
    for (int i = 0; i < nodes.size(); i++) {
      int j = i + 1;
      while (j < nodes.size() && !isRelative[nodes.get(i)][nodes.get(j)]) {
        j++;
      }
      if (j < nodes.size()) {
        if (null == children[nodes.get(j)]) {
          children[nodes.get(j)] = new ArrayList<>();
        }
        children[nodes.get(j)].add(nodes.get(i));
        if (relative[nodes.get(j)].size() == relative[nodes.get(i)].size()) {
          result = 2;
        }
      } else if (root == -1) {
        root = nodes.get(i);
      } else {
        return 0;
      }
    }
    dfs(root, 0);
    return result;
  }

  private int dfs(int cur, int depth) {
    if (result == 0) {
      return -1;
    }
    if (visited.contains(cur)) {
      result = 0;
      return -1;
    }
    visited.add(cur);
    int sum = 0;
    if (children[cur] != null) {
      for (int child : children[cur]) {
        sum += dfs(child, depth + 1);
      }
    }
    if (sum + depth != relative[cur].size()) {
      result = 0;
      return -1;
    }
    return sum + 1;
  }

}