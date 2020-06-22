package question1245_tree_diameter;

import java.util.HashSet;
import java.util.Set;

/**
 * 两次 DFS。
 *
 * 第一次先以任一点为根，找到其中最长的点为第二次的根（如果有多个任意选一个）。
 *
 * 第二次以第一次 DFS 后得出的点为根，此时 DFS 的最长的距离就是直径。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：20ms，击败27.65%。消耗内存：41.8MB，击败50.00%。
 */
public class Solution {
    private Set<Integer>[] graph;

    private boolean[] visited;

    private int result = Integer.MIN_VALUE;

    private int node1;

    public int treeDiameter(int[][] edges) {
        graph = new Set[edges.length + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        visited = new boolean[graph.length];
        visited[0] = true;
        dfs(0, 0);
        visited[0] = false;
        visited[node1] = true;
        dfs(node1, 0);
        return result;
    }

    private void dfs(int now, int len) {
        if (result < len) {
            result = len;
            node1 = now;
        }
        for (int next : graph[now]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, len + 1);
                visited[next] = false;
            }
        }
    }
}