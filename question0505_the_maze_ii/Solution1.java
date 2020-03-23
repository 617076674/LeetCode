package question0505_the_maze_ii;

import java.util.Arrays;

/**
 * 深度优先遍历
 */
public class Solution1 {
    private int m, n;

    private int[][] distances;

    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        distances = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        distances[start[0]][start[1]] = 0;
        dfs(maze, start);
        return distances[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distances[destination[0]][destination[1]];
    }

    private void dfs(int[][] maze, int[] now) {
        for (int i = 0; i < 4; i++) {
            int x = now[0], y = now[1];
            while (x + directions[i][0] >= 0 && y + directions[i][1] >= 0 && x + directions[i][0] < m && y + directions[i][1] < n && maze[x + directions[i][0]][y + directions[i][1]] == 0) {
                x += directions[i][0];
                y += directions[i][1];
            }
            int step = Math.abs(x - now[0]) + Math.abs(y - now[1]);
            if (distances[now[0]][now[1]] + step < distances[x][y]) {
                distances[x][y] = distances[now[0]][now[1]] + step;
                dfs(maze, new int[]{x, y});
            }
        }
    }
}