package question0329;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是O(m * n)，其中m为矩阵的行数，n为矩阵的列数。
 *
 * 执行用时：23ms，击败42.96%。消耗内存：50.5MB，击败38.74%。
 */
public class Solution2 {
    private int result;

    private int m;

    private int n;

    private boolean[][] visited;

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        if (null == matrix || (m = matrix.length) == 0) {
            return 0;
        }
        if (null == matrix[0] || (n = matrix[0].length) == 0) {
            return 0;
        }
        visited = new boolean[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                result = Math.max(result, longestIncreasingPath(matrix, i, j));
                visited[i][j] = false;
            }
        }
        return result;
    }

    private int longestIncreasingPath(int[][] matrix, int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        int maxLen = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0], newY = y + directions[i][1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && matrix[newX][newY] > matrix[x][y]) {
                visited[newX][newY] = true;
                maxLen = Math.max(maxLen, 1 + longestIncreasingPath(matrix, newX, newY));
                visited[newX][newY] = false;
            }
        }
        dp[x][y] = maxLen;
        return maxLen;
    }
}