package question0685_redundant_connection_ii;

public class Solution {

    private int[] parent;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        parent = new int[edges.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int result = edges.length - 1;
        while (result > 0) {
            // 判断删除掉第 result 条边后是不是一棵有根树
            for (int i = 0; i < edges.length; i++) {
                if (i != result) {
                    unionTwo(edges[i][0] - 1, edges[i][1] - 1);
                }
            }
            int root = -1;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) {
                    root = i;
                    break;
                }
            }
            boolean flag = true;
            if (root != -1) {
                for (int i = 0; i < parent.length; i++) {
                    if (root != i) {
                        if (findParent(i) != root) {
                            flag = false;
                        }
                    }
                }
            } else {
                flag = false;
            }
            if (flag) {
                break;
            }
            result--;
        }
        return edges[result];
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