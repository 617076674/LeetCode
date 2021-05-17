package question1519_number_of_nodes_in_the_sub_tree_with_the_same_label;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private List<Integer>[] graph;

  private boolean[] visited;

  private int[] result;

  public int[] countSubTrees(int n, int[][] edges, String labels) {
    graph = new List[n];
    for (int[] edge : edges) {
      int node0 = edge[0], node1 = edge[1];
      if (null == graph[node0]) {
        graph[node0] = new ArrayList<>();
      }
      graph[node0].add(node1);
      if (null == graph[node1]) {
        graph[node1] = new ArrayList<>();
      }
      graph[node1].add(node0);
    }
    result = new int[n];
    visited = new boolean[n];
    dfs(0, labels);
    return result;
  }

  public int[] dfs(int node, String labels) {
    visited[node] = true;
    int[] curCounts = new int[26];
    curCounts[labels.charAt(node) - 'a']++;
    List<Integer> nodesList = graph[node];
    for (int nextNode : nodesList) {
      if (!visited[nextNode]) {
        int[] childCounts = dfs(nextNode, labels);
        for (int i = 0; i < 26; i++) {
          curCounts[i] += childCounts[i];
        }
      }
    }
    result[node] = curCounts[labels.charAt(node) - 'a'];
    return curCounts;
  }

}