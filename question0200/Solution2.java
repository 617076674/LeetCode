package question0200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的广度优先遍历求连通分量。
 *
 * 时间复杂度是O(m * n)，其中m为grid数组的行数，n是grid数组的列数。空间复杂度是O(min(m, n))。
 *
 * 执行用时：10ms，击败18.60%。消耗内存：40.3MB，击败92.92%。
 */
public class Solution2 {
    private class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(new Pair(i, j));
                    grid[i][j] = '0';   //将遍历过的节点标记为'0'，省去了一个visited数组的开销
                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int newX = pair.x + direction[k][0];
                            int newY = pair.y + direction[k][1];
                            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == '1') {
                                queue.add(new Pair(newX, newY));
                                grid[newX][newY] = '0';
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}