package question0368_largest_divisible_subset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  private List<Integer>[] memo;

  private Set<Integer>[] graph;

  public List<Integer> largestDivisibleSubset(int[] nums) {
    graph = new HashSet[nums.length];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i != j) {
          if ((nums[i] % nums[j]) == 0) {
            if (graph[i] == null) {
              graph[i] = new HashSet<>();
            }
            graph[i].add(j);
          } else if ((nums[j] % nums[i]) == 0) {
            if (graph[j] == null) {
              graph[j] = new HashSet<>();
            }
            graph[j].add(i);
          }
        }
      }
    }
    List<Integer> result = new ArrayList<>();
    memo = new ArrayList[nums.length];
    for (int i = 0; i < graph.length; i++) {
      List<Integer> temp = dfs(nums, i);
      if (temp.size() > result.size()) {
        result = temp;
      }
    }
    return result;
  }

  private List<Integer> dfs(int[] nums, int cur) {
    if (memo[cur] != null) {
      return memo[cur];
    }
    memo[cur] = new ArrayList<>();
    memo[cur].add(nums[cur]);
    if (null == graph[cur]) {
      return memo[cur];
    }
    List<Integer> next = new ArrayList<>();

    for (int j : graph[cur]) {
      List<Integer> temp = dfs(nums, j);
      if (temp.size() > next.size()) {
        next = temp;
      }
    }
    memo[cur].addAll(next);
    return memo[cur];
  }
}