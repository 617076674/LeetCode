package question0684_redundant_connection;

/**
 * 深度优先遍历求连通分量个数。
 *
 * 时间复杂度是O(n ^ 2)，其中n为输入的边数。空间复杂度是O(n)。
 *
 * 执行用时：111ms，击败5.49%。消耗内存44.3MB，击败5.77%。
 */
public class Solution1 {

    private boolean[][] graph;

    private boolean[] visited;

    private int n;

    public int[] findRedundantConnection(int[][] edges) {
        n = edges.length;
        graph = new boolean[n][n];
        for (int[] edge : edges) {
            int node1 = edge[0] - 1, node2 = edge[1] - 1;
            visited = new boolean[n];
            if (hasPath(node1, node2)) {
                return edge;
            }
            graph[node1][node2] = true;
            graph[node2][node1] = true;
        }
        return null;
    }

    private boolean hasPath(int source, int destination) {
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        for (int i = 0; i < n; i++) {
            if (graph[source][i] && !visited[i] && hasPath(i, destination)) {
                return true;
            }
        }
        return false;
    }

}