package question0323_number_of_connected_components_in_an_undirected_graph;

import java.util.HashSet;
import java.util.Set;

/**
 * 深搜。
 *
 * 时间复杂度和空间复杂度均是O(n)。
 *
 * 执行用时：8ms，击败50.91%。消耗内存：44.7MB，击败100.00%。
 */
public class Solution1 {
    private Set<Integer>[] graph;

    private boolean[] visited;

    public int countComponents(int n, int[][] edges) {
        graph = new Set[n];
        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0], node2 = edges[i][1];
            if (null == graph[node1]) {
                graph[node1] = new HashSet<>();
            }
            graph[node1].add(node2);
            if (null == graph[node2]) {
                graph[node2] = new HashSet<>();
            }
            graph[node2].add(node1);
        }
        visited = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }
        return result;
    }

    private void dfs(int now) {
        visited[now] = true;
        if (null != graph[now]) {
            for (int next : graph[now]) {
                if (!visited[next]) {
                    dfs(next);
                }
            }
        }
    }
}