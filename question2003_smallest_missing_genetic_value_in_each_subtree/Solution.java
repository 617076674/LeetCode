package question2003_smallest_missing_genetic_value_in_each_subtree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

  private Set<Integer> set = new HashSet<>();

  private Set<Integer>[] graph;

  private boolean[] visited;

  public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
    int[] res = new int[parents.length];
    Arrays.fill(res, 1);
    int indexOf1 = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        indexOf1 = i;
        break;
      }
    }
    if (indexOf1 == -1) {
      return res;
    }
    graph = new HashSet[parents.length];
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new HashSet<>();
    }
    for (int i = 1; i < parents.length; i++) {
      graph[parents[i]].add(i);
    }
    // 节点 indexOf1 的基因值是 1
    int temp = 2, cur = indexOf1;
    visited = new boolean[parents.length];
    while (cur != -1) {
      dfs(cur, nums);
      while (set.contains(temp)) {
        temp++;
      }
      res[cur] = temp;
      visited[cur] = true;
      cur = parents[cur];
    }
    return res;
  }

  private void dfs(int cur, int[] nums) {
    set.add(nums[cur]);
    visited[cur] = true;
    for (int next : graph[cur]) {
      if (!visited[next]) {
        dfs(next, nums);
      }
    }
  }

}