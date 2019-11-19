package question0994_rotting_oranges;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 广搜。
 *
 * 时间复杂度和空间复杂度均是O(mn)，其中m为grid的行数，n为grid的列数。
 *
 * 执行用时：3ms，击败92.40%。消耗内存：38MB，击败80.52%。
 */
public class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> depth = new HashMap();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    int code = i * n + j;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int result = 0;
        while (!queue.isEmpty()) {
            int code = queue.poll(), x = code / n, y = code % n;
            for (int i = 0; i < 4; ++i) {
                int newX = x + directions[i][0], newY = y + directions[i][1];
                if (0 <= newX && newX < m && 0 <= newY && newY < n && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2;
                    int newCode = newX * n + newY;
                    queue.add(newCode);
                    depth.put(newCode, depth.get(code) + 1);
                    result = depth.get(newCode);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (1 == grid[i][j]) {
                    return -1;
                }
            }
        }
        return result;
    }
}