package question0052_n_queens_ii;

/**
 * https://leetcode-cn.com/problems/n-queens-ii/
 *
 * 回溯法。
 *
 * 时间复杂度是O(n ^ n)。空间复杂度是O(n ^ 2)。
 *
 * 执行用时：38ms，击败5.22%。消耗内存：38.3MB，击败5.00%。
 */
public class Solution1 {
    private int result;

    private int[] position;

    public int totalNQueens(int n) {
        boolean[][] visited = new boolean[n][n];
        position = new int[n];    //第i行的皇后放在第position[i]列
        totalNQueens(0, n, visited);
        return result;
    }

    private void totalNQueens(int m, int n, boolean[][] visited) {
        if (m == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[m][i]) {
                position[m] = i;
                boolean[][] tmpVisited = new boolean[n][n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        tmpVisited[j][k] = visited[j][k];
                    }
                }
                for (int j = 0; j < n; j++) {
                    tmpVisited[j][i] = true;
                    tmpVisited[m][j] = true;
                    for (int k = 0; k < n; k++) {
                        if ((Math.abs(j - m) == Math.abs(k - i))) {
                            tmpVisited[j][k] = true;
                        }
                    }
                }
                totalNQueens(m + 1, n, tmpVisited);
            }
        }
    }
}