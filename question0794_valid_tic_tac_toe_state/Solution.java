package question0794_valid_tic_tac_toe_state;

public class Solution {

  public boolean validTicTacToe(String[] board) {
    char[][] tempBoard = new char[3][3];
    int countX = 0, countO = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length(); j++) {
        tempBoard[i][j] = board[i].charAt(j);
        if (board[i].charAt(j) == 'X') {
          countX++;
        } else if (board[i].charAt(j) == 'O') {
          countO++;
        }
      }
    }
    if (countX - countO != 0 && countX - countO != 1) {
      return false;
    }
    boolean xWin = win(tempBoard, 'X'), oWin = win(tempBoard, 'O');
    if ((xWin && oWin) || (xWin && countO == countX) || (oWin && countX == countO + 1)) {
      return false;
    }
    return true;
  }

  private boolean win(char[][] board, char c) {
    for (int i = 0; i < board.length; i++) {
      boolean flag = true;
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != c) {
          flag = false;
        }
      }
      if (flag) {
        return true;
      }
    }
    for (int j = 0; j < board[0].length; j++) {
      boolean flag = true;
      for (int i = 0; i < board.length; i++) {
        if (board[i][j] != c) {
          flag = false;
        }
      }
      if (flag) {
        return true;
      }
    }
    if (board[0][0] == c && board[1][1] == c && board[2][2] == c) {
      return true;
    }
    return board[0][2] == c && board[1][1] == c && board[2][0] == c;
  }

}