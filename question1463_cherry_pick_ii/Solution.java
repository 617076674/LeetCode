package question1463_cherry_pick_ii;

import java.util.Arrays;

/**
 * 记忆化搜索。
 *
 * 执行用时：27ms，击败26.85%。消耗内存：40.4MB，击败54.69%。
 */
public class Solution {
    private int rows;

    private int cols;

    private int[] directions = {-1, 0, 1};

    private int[][][] memo;

    public int cherryPickup(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        memo = new int[rows][cols][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return cherryPickup(grid, 0, 0, cols - 1);
    }

    private int cherryPickup(int[][] grid, int step, int robot1, int robot2) {
        if (step == rows) {
            return 0;
        }
        if (memo[step][robot1][robot2] != -1) {
            return memo[step][robot1][robot2];
        }
        for (int i = 0; i < directions.length; i++) {
            int nextRobot1 = robot1 + directions[i];
            if (nextRobot1 >= 0 && nextRobot1 < cols) {
                for (int j = 0; j < directions.length; j++) {
                    int nextRobot2 = robot2 + directions[j];
                    if (nextRobot2 >= 0 && nextRobot2 < cols) {
                        if (robot1 == robot2) {
                            memo[step][robot1][robot2] = Math.max(memo[step][robot1][robot2], grid[step][robot1] + cherryPickup(grid, step + 1, nextRobot1, nextRobot2));
                        } else {
                            memo[step][robot1][robot2] = Math.max(memo[step][robot1][robot2], grid[step][robot1] + grid[step][robot2] + cherryPickup(grid, step + 1, nextRobot1, nextRobot2));
                        }
                    }
                }
            }
        }
        return memo[step][robot1][robot2];
    }
}