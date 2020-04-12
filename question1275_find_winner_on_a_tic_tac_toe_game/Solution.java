package question1275_find_winner_on_a_tic_tac_toe_game;

/**
 * 暴力破解法。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：37.3MB，击败5.55%。
 */
public class Solution {
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0], y = moves[i][1];
            if ((i & 1) == 1) {
                board[x][y] = 1;
            } else {
                board[x][y] = -1;
            }
            if ((board[x][0] == board[x][y] && board[x][1] == board[x][y] && board[x][2] == board[x][y])
                    || (board[0][y] == board[x][y] && board[1][y] == board[x][y] && board[2][y] == board[x][y])
                    || (x == y && board[0][0] == board[x][y] && board[1][1] == board[x][y] && board[2][2] == board[x][y])
                    || (x + y == 2 && board[0][2] == board[x][y] && board[1][1] == board[x][y] && board[2][0] == board[x][y])) {
                return board[x][y] == 0 ? "A" : "B";
            }
        }
        if (moves.length == 9) {
            return "Draw";
        }
        return "Pending";
    }
}