package question684;

/**
 * 利用并查集求解连通分量的个数，省去了深度优先遍历思路中的建图过程。
 * <p>
 * 时间复杂度是O(n ^ 2)，空间复杂度是O(n)。
 * <p>
 * 执行时间：10ms，击败24.18%。消耗内存：36.8MB，击败80.77%。
 */
public class Solution2 {

    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int result = edges.length - 1;
        while (result > 0) {
            parent = new int[edges.length];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < edges.length; i++) {
                if (i != result) {
                    int node1 = edges[i][0] - 1, node2 = edges[i][1] - 1;
                    unionTwo(node1, node2);
                }
            }
            boolean flag = true;
            for (int i = 0; i < parent.length - 1; i++) {
                if (findParent(i) != findParent(i + 1)) {
                    flag = false;
                }
            }
            if (flag) {
                return edges[result];
            }
            result--;
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
