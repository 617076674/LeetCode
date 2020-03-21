package question0490_the_maze;

/**
 * 深度优先遍历。
 *
 * 时间复杂度和空间复杂度均是O(mn)，其中m为maze的行数，n为maze的列数。
 *
 * 执行用时：2ms，击败99.43%。消耗内存：42.7MB，击败91.67%。
 */
public class Solution {
    private boolean result;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        dfs(maze, start, destination);
        return result;
    }

    private void dfs(int[][] maze, int[] now, int[] direction) {
        if (result || maze[now[0]][now[1]] == -1) {
            return;
        }
        maze[now[0]][now[1]] = -1;
        if (now[0] == direction[0] && now[1] == direction[1]) {
            result = true;
            return;
        }
        //尝试着向上走
        int j = now[0];
        while (j - 1 >= 0 && maze[j - 1][now[1]] != 1) {
            j--;
        }
        dfs(maze, new int[]{j, now[1]}, direction);
        //尝试着向下走
        j = now[0];
        while (j + 1 < maze.length && maze[j + 1][now[1]] != 1) {
            j++;
        }
        dfs(maze, new int[]{j, now[1]}, direction);
        //尝试着向左走
        j = now[1];
        while (j - 1 >= 0 && maze[now[0]][j - 1] != 1) {
            j--;
        }
        dfs(maze, new int[]{now[0], j}, direction);
        //尝试着向右走
        j = now[1];
        while (j + 1 < maze[0].length && maze[now[0]][j + 1] != 1) {
            j++;
        }
        dfs(maze, new int[]{now[0], j}, direction);
    }
}