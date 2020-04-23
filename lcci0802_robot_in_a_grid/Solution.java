package lcci0802_robot_in_a_grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 执行用时：1ms，击败100.00%。消耗内存：41.3MB，击败100.00%。
 */
public class Solution {
    private int[][] directions = {{1, 0}, {0, 1}};

    private int m, n;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return new ArrayList<>();
        }
        return pathWithObstacles(obstacleGrid, new int[]{0, 0});
    }

    private List<List<Integer>> pathWithObstacles(int[][] obstacleGrid, int[] now) {
        obstacleGrid[now[0]][now[1]] = -1;
        if (now[0] == m - 1 && now[1] == n - 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Arrays.asList(now[0], now[1]));
            return result;
        }
        for (int i = 0; i < directions.length; i++) {
            int newX = now[0] + directions[i][0], newY = now[1] + directions[i][1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && obstacleGrid[newX][newY] == 0) {
                List<List<Integer>> result = pathWithObstacles(obstacleGrid, new int[] {newX, newY});
                if (!result.isEmpty()) {
                    result.add(0, Arrays.asList(now[0], now[1]));
                    return result;
                }
            }
        }
        return new ArrayList<>();
    }
}