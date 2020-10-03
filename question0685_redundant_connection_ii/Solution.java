package question0685_redundant_connection_ii;

/**
 * 并查集。
 *
 * 执行用时：1ms，击败99.71%。消耗内存：39.1MB，击败46.52%。
 */
public class Solution {

    private int[] parent;

    private int n;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        n = edges.length;
        parent = new int[n];
        init();
        // 1 - 有节点存在多个父亲节点的情况
        for (int i = 0; i < n; i++) {
            int node1 = edges[i][0] - 1, node2 = edges[i][1] - 1;
            if (findParent(node2) != node2) {
                // hasLoop 用以标记除去第 i 条边，剩余的边是否构成环
                boolean hasLoop = false;
                init();
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        int node3 = edges[j][0] - 1, node4 = edges[j][1] - 1;
                        if (findParent(node3) == node4) {
                            hasLoop = true;
                            break;
                        }
                        unionTwo(node4, node3);
                    }
                }
                // 如果除去第 i 条边，剩余的边构成环，则去除构成环且和第 i 条边冲突导致出现 2 个父节点的那条边
                if (hasLoop) {
                    for (int j = 0; j < n; j++) {
                        if (j != i && edges[j][1] == edges[i][1]) {
                            return edges[j];
                        }
                    }
                }
                // 如果除去第 i 条边，剩余的边不构成环，则去除第 i 条边
                return edges[i];
            }
            unionTwo(node2, node1);
        }
        // 2 - 没有节点存在多个父亲节点的情况，看有没有环
        init();
        for (int[] edge : edges) {
            int node1 = edge[0] - 1, node2 = edge[1] - 1;
            if (findParent(node1) == node2) {
                return edge;
            }
            unionTwo(node2, node1);
        }
        return null;
    }

    private void init() {
        for (int j = 0; j < n; j++) {
            parent[j] = j;
        }
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