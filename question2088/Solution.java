package question2088;

public class Solution {

    private int m;

    private int n;

    private int[][] grid;

    public int countPyramids(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        memo1 = new Integer[m][n];
        memo2 = new Integer[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result += Math.max(0, countPyramidsHelper1(i, j)) + Math.max(0, countPyramidsHelper2(i, j));
            }
        }
        return result;
    }

    private Integer[][] memo1;

    private Integer[][] memo2;

    private int countPyramidsHelper1(int x, int y) {
        if (grid[x][y] == 0) {
            return -1;
        }
        if (null != memo1[x][y]) {
            return memo1[x][y];
        }
        int height = Integer.MAX_VALUE / 2;
        if (x + 1 < m && y - 1 >= 0) {
            height = Math.min(height, countPyramidsHelper1(x + 1, y - 1));
        } else {
            height = 0;
            memo1[x][y] = height;
            return height;
        }
        if (x + 1 < m) {
            height = Math.min(height, countPyramidsHelper1(x + 1, y));
        } else {
            height = 0;
            memo1[x][y] = height;
            return height;
        }
        if (x + 1 < m && y + 1 < n) {
            height = Math.min(height, countPyramidsHelper1(x + 1, y + 1));
        } else {
            height = 0;
            memo1[x][y] = height;
            return height;
        }
        height = height >= Integer.MAX_VALUE / 2 ? 0 : (height + 1);
        memo1[x][y] = height;
        return height;
    }

    private int countPyramidsHelper2(int x, int y) {
        if (grid[x][y] == 0) {
            return -1;
        }
        if (null != memo2[x][y]) {
            return memo2[x][y];
        }
        int height = Integer.MAX_VALUE / 2;
        if (x - 1 >= 0 && y - 1 >= 0) {
            height = Math.min(height, countPyramidsHelper2(x - 1, y - 1));
        } else {
            height = 0;
            memo2[x][y] = height;
            return height;
        }
        if (x - 1 >= 0) {
            height = Math.min(height, countPyramidsHelper2(x - 1, y));
        } else {
            height = 0;
            memo2[x][y] = height;
            return height;
        }
        if (x - 1 >= 0 && y + 1 < n) {
            height = Math.min(height, countPyramidsHelper2(x - 1, y + 1));
        } else {
            height = 0;
            memo2[x][y] = height;
            return height;
        }
        height = height >= Integer.MAX_VALUE / 2 ? 0 : (height + 1);
        memo2[x][y] = height;
        return height;
    }

}