package question0200_number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * 图的广度优先遍历求连通分量。
 *
 * 时间复杂度是O(m * n)，其中m为grid数组的行数，n是grid数组的列数。空间复杂度是O(min(m, n))。
 *
 * 执行用时：6ms，击败27.13%。消耗内存：41.2MB，击败84.22%。
 */
public class Solution2 {
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int m, n;

    public int numIslands(char[][] grid) {
        if (null == grid || (m = grid.length) == 0) {
            return 0;
        }
        if (null == grid[0] || (n = grid[0].length) == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * n + j);
                    grid[i][j] = '0';   //将遍历过的节点标记为'0'，省去了一个visited数组的开销
                    while (!queue.isEmpty()) {
                        int num = queue.poll(), x = num / n, y = num % n;
                        for (int k = 0; k < 4; k++) {
                            int newX = x + directions[k][0], newY = y + directions[k][1];
                            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == '1') {
                                queue.add(newX * n + newY);
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