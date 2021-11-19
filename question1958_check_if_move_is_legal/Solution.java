package question1958_check_if_move_is_legal;

public class Solution {

  public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    board[rMove][cMove] = color;
    for (int[] direction : directions) {
        int j = 1;
        boolean flag = true;
        while (true) {
            int nextR = rMove + j * direction[0], nextC = cMove + j * direction[1];
            if (nextR >= 0 && nextR < 8 && nextC >= 0 && nextC < 8) {
                if (board[nextR][nextC] == color) {
                    break;
                } else if (board[nextR][nextC] == '.') {
                    flag = false;
                    break;
                }
            } else {
                flag = false;
                break;
            }
            j++;
        }
        if (flag && j > 1) {
            return true;
        }
    }
    return false;
  }

}