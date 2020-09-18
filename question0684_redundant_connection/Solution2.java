package question0684_redundant_connection;

/**
 * 利用并查集求解连通分量的个数，省去了深度优先遍历思路中的建图过程。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行时间：10ms，击败24.18%。消耗内存：36.8MB，击败80.77%。
 */
public class Solution2 {

    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int node1 = edge[0] - 1, node2 = edge[1] - 1;
            if (findParent(node1) == findParent(node2)) {
                return edge;
            }
            unionTwo(node1, node2);
        }
        return null;
    }

    private int findParent(int x) {
        int a = x;
        while (x != parent[x]) {
            x = parent[x];
        }
        while (a != parent[a]) {
            int z = a;
            a = parent[a];
            parent[z] = x;
        }
        return x;
    }

    private void unionTwo(int a, int b) {
        int aParent = findParent(a);
        int bParent = findParent(b);
        if (aParent != bParent) {
            parent[aParent] = bParent;
        }
    }

}