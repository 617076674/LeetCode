package lcof12_ju_zhen_zhong_de_lu_jing;

/**
 * 回溯。
 *
 * 时间复杂度是 O(m * n * 3 ^ k)，其中 m 为矩阵 board 的行数，n 为矩阵 board 的列数，k 为字符串 word 的长度。空间复杂度是 O(k)。
 *
 * 执行用时：8ms，击败37.82%。消耗内存：41.9MB，击败100.00%。
 */
public class Solution {
    private boolean result;

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && !result) {
                    char tmp = board[i][j];
                    board[i][j] = '-';
                    dfs(board, word, 1, i, j);
                    board[i][j] = tmp;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] board, String word, int index, int x, int y) {
        if (result) {
            return;
        }
        if (index == word.length()) {
            result = true;
            return;
        }
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0], newY = y + directions[i][1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && board[newX][newY] == word.charAt(index)) {
                char tmp = board[newX][newY];
                board[newX][newY] = '-';
                dfs(board, word, index + 1, newX, newY);
                board[newX][newY] = tmp;
            }
        }
    }
}