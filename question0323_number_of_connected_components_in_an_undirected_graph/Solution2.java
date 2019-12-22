package question0323_number_of_connected_components_in_an_undirected_graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 广搜。
 *
 * 时间复杂度和空间复杂度均是O(n)。
 *
 * 执行用时：17ms，击败33.33%。消耗内存：44.6MB，击败100.00%。
 */
public class Solution2 {
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
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    int now = queue.poll();
                    visited[now] = true;
                    if (null != graph[now]) {
                        for (int next : graph[now]) {
                            if (!visited[next]) {
                                queue.add(next);
                            }
                        }
                    }
                }
                result++;
            }
        }
        return result;
    }
}