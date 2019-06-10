package question684;

/**
 * 深度优先遍历求连通分量个数。
 *
 * 时间复杂度是O(n ^ 2)，其中n为输入的边数。空间复杂度是O(n)。
 *
 * 执行用时：111ms，击败5.49%。消耗内存44.3MB，击败5.77%。
 */
public class Solution1 {

    boolean[][] graph;

    boolean[] visited;

    public int[] findRedundantConnection(int[][] edges) {
        graph = new boolean[edges.length][edges.length];
        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0] - 1, node2 = edges[i][1] - 1;
            graph[node1][node2] = true;
            graph[node2][node1] = true;
        }
        for (int i = edges.length - 1; i >= 0; i--) {
            int node1 = edges[i][0] - 1, node2 = edges[i][1] - 1;
            graph[node1][node2] = false;
            graph[node2][node1] = false;
            int count = 0;
            visited = new boolean[edges.length];
            for (int j = 0; j < edges.length; j++) {
                if (!visited[j]) {
                    dfs(j);
                    count++;
                }
            }
            if (count == 1) {
                return edges[i];
            }
            graph[node1][node2] = true;
            graph[node2][node1] = true;
        }
        return null;
    }

    private void dfs(int start) {
        visited[start] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[start][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

}
