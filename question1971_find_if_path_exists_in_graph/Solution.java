package question1971_find_if_path_exists_in_graph;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private Set<Integer>[] graph;

    private boolean[] visited;

    public boolean validPath(int n, int[][] edges, int start, int end) {
        graph = new HashSet[n];
        for (int[] edge : edges) {
            if (graph[edge[0]] == null) {
                graph[edge[0]] = new HashSet<>();
            }
            graph[edge[0]].add(edge[1]);
            if (graph[edge[1]] == null) {
                graph[edge[1]] = new HashSet<>();
            }
            graph[edge[1]].add(edge[0]);
        }
        visited = new boolean[n];
        dfs(start);
        return visited[end];
    }

    private void dfs(int cur) {
        visited[cur] = true;
        if (null == graph[cur]) {
            return;
        }
        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

}