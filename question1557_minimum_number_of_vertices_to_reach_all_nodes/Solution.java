package question1557_minimum_number_of_vertices_to_reach_all_nodes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    private boolean[] visited;

    private Set<Integer>[] graph;

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];
        graph = new Set[n];
        for (List<Integer> edge : edges) {
            inDegree[edge.get(1)]++;
            if (null == graph[edge.get(0)]) {
                graph[edge.get(0)] = new HashSet<>();
            }
            graph[edge.get(0)].add(edge.get(1));
        }
        visited = new boolean[n];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                result.add(i);
                visited[i] = true;
                dfs(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
                result.add(i);
            }
        }
        return result;
    }

    private void dfs(int now) {
        if (null == graph[now]) {
            return;
        }
        for (int next : graph[now]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }

}