package question0289;

/**
 * @author qianyihui
 * @date 2019-07-30
 *
 * 特殊标记法。如果原来是1，需要改变状态，则将其标记为-1。如果原来是0，需要改变状态，将其标记位-2。
 *
 * 最后统一遍历数组将-1转为0，将-2转为1。
 *
 * 时间复杂度是O(mn)，其中m为board数组的行数，n为board数组的列数。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败96.10%。消耗内存：35.7MB，击败51.85%。
 */
public class Solution2 {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        if (n == 0) {
            return;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (willChange(board, i, j)) {
                    if (board[i][j] == 1 || board[i][j] == -1) {
                        board[i][j] = -1;
                    } else {
                        board[i][j] = -2;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == -2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private boolean willChange(int[][] board, int x, int y) {
        int count = 0;
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && (board[newX][newY] == 1 || board[newX][newY] == -1)) {
                count++;
            }
        }
        if (board[x][y] == 1 || board[x][y] == -1) {
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
