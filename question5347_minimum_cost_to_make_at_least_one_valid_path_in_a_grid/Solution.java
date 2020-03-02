package question5347_minimum_cost_to_make_at_least_one_valid_path_in_a_grid;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历。
 *
 * 执行用时：60ms，击败100.00%。消耗内存：41.3MB，击败100.00%。
 */
public class Solution {
    public int minCost(int[][] grid) {
        int m;
        if (null == grid || (m = grid.length) == 0) {
            return 0;
        }
        int n;
        if (null == grid[0] || (n = grid[0].length) == 0) {
            return 0;
        }
        int[][] cost = new int[m][n], directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        cost[0][0] = 0;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + directions[i][0], newY = y + directions[i][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int tmp = cost[x][y];
                    if (grid[x][y] != i + 1) {
                        tmp++;
                    }
                    if (tmp < cost[newX][newY]) {   //如果可以更新cost数组中的值，那么将该节点入队
                        cost[newX][newY] = tmp;
                        queue.add(new int[] {newX, newY});
                    }
                }
            }
        }
        return cost[m - 1][n - 1];
    }
}