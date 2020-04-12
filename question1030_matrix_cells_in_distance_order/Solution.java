package question1030_matrix_cells_in_distance_order;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广搜。
 *
 * 时间复杂度和空间复杂度均是O(R * C)。
 *
 * 执行用时：11ms，击败85.29%。消耗内存：43.1MB，击败5.56%。
 */
public class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Queue<Integer> queue = new LinkedList<>();
        int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        boolean[] visited = new boolean[R * C];
        visited[r0 * C + c0] = true;
        queue.add(r0 * C + c0);
        int[][] result = new int[R * C][2];
        int index = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll(), x = now / C, y = now % C;
            result[index++] = new int[] {x, y};
            for (int j = 0; j < 4; j++) {
                int newX = x + directions[j][0], newY = y + directions[j][1];
                if (newX >= 0 && newX < R && newY >= 0 && newY < C && !visited[newX * C + newY]) {
                    visited[newX * C + newY] = true;
                    queue.add(newX * C + newY);
                }
            }
        }
        return result;
    }
}