package question0419_battleships_in_a_board;

/**
 * 深度优先遍历。
 *
 * 时间复杂度和空间复杂度均是O(mn)，其中m是board的行数，n是board的列数。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：51.2MB，击败5.02%。
 */
public class Solution1 {
    private boolean[][] visited;

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int m, n;

    public int countBattleships(char[][] board) {
        if (null == board || (m = board.length) == 0 || null == board[0] || (n = board[0].length) == 0) {
            return 0;
        }
        visited = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && !visited[i][j]) {
                    result++;
                    dfs(i, j, board);
                }
            }
        }
        return result;
    }

    private void dfs(int i, int j, char[][] board) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newI = i + directions[k][0], newJ = j + directions[k][1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ] && board[newI][newJ] == 'X') {
                dfs(newI, newJ, board);
            }
        }
    }
}