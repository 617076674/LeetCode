package question0959_regions_cut_by_slashes;

/**
 * 并查集。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 2)，其中 n 为 grid 数组的长度。
 *
 * 执行用时：9ms，击败48.81%。消耗内存：38.1MB，击败100.00%。
 */
public class Solution {
    private int[] parent;

    public int regionsBySlashes(String[] grid) {
        int n;
        if (null == grid || (n = grid.length) == 0) {
            return 0;
        }
        parent = new int[4 * n * n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                if (grid[i].charAt(j) == '\\') {
                    union(index, index + 1);
                    union(index + 2, index + 3);
                } else if (grid[i].charAt(j) == '/') {
                    union(index, index + 3);
                    union(index + 1, index + 2);
                } else {
                    union(index, index + 1);
                    union(index + 1, index + 2);
                    union(index + 2, index + 3);
                }
                if (i - 1 >= 0) {
                    union(index + 1, 4 * ((i - 1) * n + j) + 3);
                }
                if (i + 1 < n) {
                    union(index + 3, 4 * ((i + 1) * n + j) + 1);
                }
                if (j - 1 >= 0) {
                    union(index + 2, 4 * (i * n + j - 1));
                }
                if (j + 1 < n) {
                    union(index, 4 * (i * n + j + 1) + 2);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < parent.length; i++) {
            if (findParent(i) == i) {
                result++;
            }
        }
        return result;
    }

    private void union(int a, int b) {
        int aParent = findParent(a), bParent = findParent(b);
        if (aParent != bParent) {
            parent[aParent] = bParent;
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
}