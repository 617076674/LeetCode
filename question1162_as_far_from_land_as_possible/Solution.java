package question1162_as_far_from_land_as_possible;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广搜。
 *
 * 时间复杂度和空间复杂度均是O(m * n)，其中m为grid矩阵的行数，n为grid矩阵的列数。
 *
 * 执行用时：16ms，击败89.75%。消耗内存：42.6MB，击败99.00%。
 */
public class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(i * m + j);
                    grid[i][j] = -1;
                }
            }
        }
        if (queue.size() == m * n) {
            return -1;
        }
        int distance = 0;
        int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int now = queue.poll(), x = now / m, y = now % m;
                for (int j = 0; j < 4; j++) {
                    int newX = x + directions[j][0], newY = y + directions[j][1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] != -1) {
                        grid[newX][newY] = -1;
                        queue.add(newX * m + newY);
                    }
                }
            }
            distance++;
        }
        return distance - 1;
    }
}