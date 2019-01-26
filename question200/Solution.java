package question200;

public class Solution {
    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] visited;
    public int numIslands(char[][] grid) {
        if(grid.length == 0) {
            return 0;
        }
        visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j) {
        visited[i][j] = true;
        for(int k = 0; k < 4; k++) {
            int newi = i + direction[k][0];
            int newj = j + direction[k][1];
            if(isValid(grid, newi, newj) && grid[newi][newj] == '1' && !visited[newi][newj]) {
                dfs(grid, newi, newj);
            }
        }
        return;
    }
    private boolean isValid(char[][] grid, int i, int j) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            return true;
        }
        return false;
    }
}

