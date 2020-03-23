package question0499_the_maze_iii;

import java.util.Arrays;

public class Solution {
    private int m, n;

    private int[][] distances;

    private int[][] directions = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};    //与chars相对应

    private char[] chars = {'d', 'l', 'r', 'u'};    //按字典排序

    private String result;

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        m = maze.length;
        n = maze[0].length;
        distances = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        distances[ball[0]][ball[1]] = 0;
        dfs(maze, ball, hole, new StringBuilder());
        System.out.println(distances[hole[0]][hole[1]]);
        return result == null ? "impossible" : result;
    }

    private void dfs(int[][] maze, int[] ball, int[] hole, StringBuilder sb) {
        for (int i = 0; i < 4; i++) {
            int x = ball[0], y = ball[1];
            while (x + directions[i][0] >= 0 && y + directions[i][1] >= 0 && x + directions[i][0] < m && y + directions[i][1] < n && maze[x + directions[i][0]][y + directions[i][1]] == 0) {
                x += directions[i][0];
                y += directions[i][1];
                if (x == hole[0] && y == hole[1]) {
                    break;
                }
            }
            int step = Math.abs(x - ball[0]) + Math.abs(y - ball[1]);
            if (distances[ball[0]][ball[1]] + step < distances[x][y]) {
                distances[x][y] = distances[ball[0]][ball[1]] + step;
                sb.append(chars[i]);
                if (x == hole[0] && y == hole[1]) {
                    result = sb.toString();
                }
                dfs(maze, new int[]{x, y}, hole, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}