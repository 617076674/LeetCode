package question0807_max_increase_to_keep_city_skyline;

public class Solution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] topBottomLine = new int[grid.length], leftRightLine = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                topBottomLine[i] = Math.max(topBottomLine[i], grid[j][i]);
                leftRightLine[i] = Math.max(leftRightLine[i], grid[i][j]);
            }
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                result += Math.min(topBottomLine[j], leftRightLine[i]) - grid[i][j];
            }
        }
        return result;
    }

}