package lcci0401_route_between_nodes;

import java.util.*;

/**
 * 深搜。
 *
 * 执行用时：33ms，击败47.42%。消耗内存：86.7MB，击败100.00%。
 */
public class Solution2 {
    private Set<Integer>[] trueGraph;

    private boolean[] visited;

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        trueGraph = new HashSet[n];
        for (int i = 0; i < graph.length; i++) {
            if (trueGraph[graph[i][0]] == null) {
                trueGraph[graph[i][0]] = new HashSet<>();
            }
            trueGraph[graph[i][0]].add(graph[i][1]);
        }
        visited = new boolean[n];
        dfs(start, target);
        return visited[target];
    }

    private void dfs(int now, int target) {
        visited[now] = true;
        if (now == target) {
            return;
        }
        Set<Integer> set = trueGraph[now];
        if (set != null) {
            for (int next : set) {
                if (!visited[next]) {
                    dfs(next, target);
                }
            }
        }
    }
}