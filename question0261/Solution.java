package question0261;

/**
 * @author qianyihui
 * @date 2019-08-11
 *
 * 并查集。
 *
 * 时间复杂度是O(m)，其中m为边数。空间复杂度是O(n)。
 *
 * 执行用时：2ms，击败72.73%。消耗内存：43.6MB，击败100.00%。
 */
public class Solution {
    private int[] parent;

    public boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            //如果考虑这条边之前已经存在共同父亲节点，加入这条边一定会成环，不是一颗合法的树
            if (findParent(edges[i][0]) == findParent(edges[i][1])) {
                return false;
            }
            union(edges[i][0], edges[i][1]);
        }
        int tmp = findParent(0);
        for (int i = 1; i < n; i++) {
            if (findParent(i) != tmp) {
                return false;
            }
        }
        return true;
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

    private void union(int a, int b) {
        int aParent = findParent(a), bParent = findParent(b);
        if (aParent != bParent) {
            parent[aParent] = bParent;
        }
    }
}
