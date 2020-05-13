package question0130_surrounded_regions;

/**
 * 深度优先遍历。
 *
 * 时间复杂度是O(m * n)，其中m为board数组的行数，n为board数组的列数。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败98.59%。消耗内存：42MB，击败56.25%。
 */
public class Solution1 {
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int m, n;

    public void solve(char[][] board) {
        if (null == board || (m = board.length) == 0) {
            return;
        }
        if (null == board[0] || (n = board[0].length) == 0) {
            return;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        board[i][j] = '*';
        for (int k = 0; k < 4; k++) {
            int newI = i + directions[k][0], newJ = j + directions[k][1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && board[newI][newJ] == 'O') {
                dfs(board, newI, newJ);
            }
        }
    }
}