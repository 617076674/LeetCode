package lcp21;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

  private Set<Integer>[] graph;

  private int[] depth, parent;

  private boolean[] inLoop;

  private int loopLen;

  private int n;

  public int chaseGame(int[][] edges, int startA, int startB) {
    n = edges.length;
    graph = new HashSet[n + 1];
    for (int[] edge : edges) {
      if ((startA == edge[0] && startB == edge[1]) || (startA == edge[1] && startB == edge[0])) {
        return 1;
      }
      if (null == graph[edge[0]]) {
        graph[edge[0]] = new HashSet<>();
      }
      graph[edge[0]].add(edge[1]);
      if (null == graph[edge[1]]) {
        graph[edge[1]] = new HashSet<>();
      }
      graph[edge[1]].add(edge[0]);
    }
    depth = new int[n + 1];
    parent = new int[n + 1];
    inLoop = new boolean[n + 1];
    dfs(1, 0);
    // BFS 求出 A 和 B 到所有点的最短距离
    int[] da = bfs(startA), db = bfs(startB);
    if (loopLen > 3) {
      // 寻找 B 到环的入口及距离
      for (int i = 1; i <= n; i++) {
        if (inLoop[i] && da[i] > db[i] + 1) {
          return -1;
        }
      }
    }
    // 此时 A 一定能捉到 B，B 要使自己尽可能晚被捉到
    int result = 0;
    for (int i = 1; i <= n; i++) {
      // 如果一个点到 A 的最短距离大于到 B 的最短距离加 1，这个点就是 B 可以安全到达的点，用它来更新最后的结果
      if (da[i] > db[i] + 1) {
        result = Math.max(result, da[i]);
      }
    }
    return result;
  }

  private void dfs(int cur, int curParent) {
    parent[cur] = curParent;
    depth[cur] = depth[curParent] + 1;
    if (graph[cur] == null) {
      return;
    }
    for (int child : graph[cur]) {
      if (child == curParent) {
        continue;
      }
      if (depth[child] == 0) {
        dfs(child, cur);
      } else {
        if (depth[child] < depth[cur]) {
          // 发现反向边，说明找到了环
          int temp = cur;
          while (temp != child) {
            inLoop[temp] = true;
            loopLen++;
            temp = parent[temp];
          }
          inLoop[child] = true;
          loopLen++;
        }
      }
    }
  }

  private int[] bfs(int start) {
    int[] result = new int[n + 1];
    Arrays.fill(result, Integer.MAX_VALUE / 2);
    Queue<Integer> queue = new LinkedList<>();
    result[start] = 0;
    queue.add(start);
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      if (null != graph[cur]) {
        for (int next : graph[cur]) {
          if (result[next] <= result[cur] + 1) {
            continue;
          }
          result[next] = result[cur] + 1;
          queue.add(next);
        }
      }
    }
    return result;
  }

}