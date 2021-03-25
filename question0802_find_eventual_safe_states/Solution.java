package question0802_find_eventual_safe_states;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private List<Integer> result = new ArrayList<>();

  // color[i] == 0， 节点 i 未被访问
  // color[i] == 1，节点 i 在本轮访问中
  // color[i] == 2，节点 i 是安全节点
  private int[] color;

  public List<Integer> eventualSafeNodes(int[][] graph) {
    color = new int[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (dfs(i, graph)) {
        result.add(i);
      }
    }
    return result;
  }

  // 当前节点 now 是不是处于安全状态
  private boolean dfs(int now, int[][] graph) {
    if (color[now] > 0) {
      return color[now] == 2;
    }
    if (graph[now].length == 0) {
      return true;
    }
    color[now] = 1;
    for (int next : graph[now]) {
      if (color[next] == 1 || !dfs(next, graph)) {
        return false;
      }
    }
    color[now] = 2;
    return true;
  }

}