package question0289;

/**
 * @author qianyihui
 * @date 2019-07-30
 *
 * 用一个二维数组记录哪些位置的状态要改变。
 *
 * 时间复杂度和空间复杂度均是O(mn)，其中m为board数组的行数，n为board数组的列数。
 *
 * 执行用时：1ms，击败96.10%。消耗内存：35.4MB，击败54.08%。
 */
public class Solution1 {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

    private boolean[][] needChange;

    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        if (n == 0) {
            return;
        }
        needChange = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (willChange(board, i, j)) {
                    needChange[i][j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (needChange[i][j]) {
                    board[i][j] = 1 - board[i][j];
                }
            }
        }
    }

    private boolean willChange(int[][] board, int x, int y) {
        int count = 0;
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] == 1) {
                count++;
            }
        }
        if (board[x][y] == 1) {
            if (count < 2 || count > 3) {
                return true;
            }
            return false;
        } else {
            if (count == 3) {
                return true;
            }
            return false;
        }
    }
}
