package question0694;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private Set<String> islandSet = new HashSet<>();

    private int flag = 2;

    private int m, n;

    private int[][] grid;

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private Set<Integer> visitedFlag = new HashSet<>();

    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = flag;
                    dfs(i, j);
                }
                flag++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (visitedFlag.contains(grid[i][j])) {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                for (int row = i; row < m; row++) {
                    int col = j;
                    while (col < n && grid[i][j] == grid[row][col]) {
                        col++;
                    }
                    // [j, col - 1]
                    sb.append(col - j).append("-");
                }
                islandSet.add(sb.toString());
                visitedFlag.add(grid[i][j]);
            }
        }
        return islandSet.size();
    }

    private void dfs(int x, int y) {
        for (int[] direction : DIRECTIONS) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1) {
                grid[nextX][nextY] = flag;
                dfs(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(new Solution().numDistinctIslands(grid));
    }

}