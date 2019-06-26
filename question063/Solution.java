package question063;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82834527
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        int[][] map = new int[m][n];

        int indexj = 0;
        for (; indexj < n; indexj++) {
            if (obstacleGrid[0][indexj] == 1) {
                break;
            }
        }
        for (int i = 0; i < indexj; i++) {
            map[0][i] = 1;
        }

        int indexi = 0;
        for (; indexi < m; indexi++) {
            if (obstacleGrid[indexi][0] == 1) {
                break;
            }
        }
        for (int i = 0; i < indexi; i++) {
            map[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
        }
        return map[m - 1][n - 1];
    }
}
