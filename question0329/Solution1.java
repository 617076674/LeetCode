package question0329;

/**
 * 回溯法。
 *
 * 时间复杂度是O(m * n * (4 ^ (m * n)))，其中m为矩阵的行数，n为矩阵的列数。空间复杂度是O(m * n)。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution1 {
    private int result;

    private int m;

    private int n;

    private boolean[][] visited;

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (null == matrix || (m = matrix.length) == 0) {
            return 0;
        }
        if (null == matrix[0] || (n = matrix[0].length) == 0) {
            return 0;
        }
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                dfs(matrix, i, j, 1);
                visited[i][j] = false;
            }
        }
        return result;
    }

    private void dfs(int[][] matrix, int x, int y, int len) {
        result = Math.max(result, len);
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0], newY = y + directions[i][1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && matrix[newX][newY] > matrix[x][y]) {
                visited[newX][newY] = true;
                dfs(matrix, newX, newY, len + 1);
                visited[newX][newY] = false;
            }
        }
    }
}
