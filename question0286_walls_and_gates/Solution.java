package question0286_walls_and_gates;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广搜。
 *
 * 时间复杂度和空间复杂度均为O(m * n)，其中m为rooms数组的行数，n为rooms数组的列数。
 *
 * 执行用时：26ms，击败34.82%。消耗内存：43.4MB，击败100.00%。
 */
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m;
        if (null == rooms || (m = rooms.length) == 0) {
            return;
        }
        int n;
        if (null == rooms[0] || (n = rooms[0].length) == 0) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(i * n + j);
                }
            }
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int k = 0; k < qSize; k++) {
                int now = queue.poll(), row = now / n, col = now % n;
                visited[row][col] = true;
                rooms[row][col] = Math.min(rooms[row][col], step);
                for (int l = 0; l < 4; l++) {
                    int newRow = row + directions[l][0], newCol = col + directions[l][1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && rooms[newRow][newCol] != -1 && !visited[newRow][newCol]) {
                        queue.add(newRow * n + newCol);
                    }
                }
            }
            step++;
        }
    }
}