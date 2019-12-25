package question0200_number_of_islands;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * 并查集实现。
 *
 * 如何将一个二维数组映射成一个一维数组呢？
 *
 * 我们对该二维数组进行标号，标号顺序从按(0, 0), (0, 1), ..., (0, n - 1), ... (1, 0), (1, 1), ... (1, n - 1), ...
 *
 * 这样就实现了二维数组到一维数组的变换。
 *
 * 时间复杂度和空间复杂度均是O(m * n)，其中m为grid数组的行数。n是grid数组的列数。
 */
public class Solution3 {
    private int[] parent;   //并查集数组

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int m, n;

    public int numIslands(char[][] grid) {
        if (null == grid || (m = grid.length) == 0) {
            return 0;
        }
        if (null == grid[0] || (n = grid[0].length) == 0) {
            return 0;
        }
        //初始化我们的并查集
        parent = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = i * n + j;
                if (grid[i][j] == '1') {
                    parent[tmp] = tmp;
                } else {
                    parent[tmp] = -1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int newX = i + directions[k][0], newY = j + directions[k][1];
                        if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == '1') {
                            union(i * n + j, newX * n + newY);
                        }
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                continue;
            }
            int father = findFather(i);
            set.add(father);
        }
        return set.size();
    }

    private int findFather(int x) {
        int a = x;
        while (x != parent[x]) {
            x = parent[x];
        }
        //路径压缩
        while (a != parent[a]) {
            int z = a;
            a = parent[a];
            parent[z] = x;
        }
        return x;
    }

    private void union(int a, int b) {
        int aFather = findFather(a), bFather = findFather(b);
        if (aFather != bFather) {
            parent[aFather] = bFather;
        }
    }
}