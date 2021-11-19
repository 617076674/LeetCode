package question2018_check_if_word_can_be_placed_in_crossword;

public class Solution {

  private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public boolean placeWordInCrossword(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == ' ' || board[i][j] == word.charAt(0)) {
          for (int[] direction : directions) {
            boolean flag = true;
            int k = 1;
            for (; k < word.length(); k++) {
              int curI = i + k * direction[0], curJ = j + k * direction[1];
              if (curI >= m || curI < 0 || curJ >= n || curJ < 0) {
                flag = false;
                break;
              }
              if (board[curI][curJ] == '#') {
                flag = false;
                break;
              }
              if (board[curI][curJ] != ' ' && board[curI][curJ] != word.charAt(k)) {
                flag = false;
                break;
              }
            }
            if (flag && k == word.length()) {
              int nextI = i + word.length() * direction[0], nextJ = j + word.length() * direction[1];
              if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && board[nextI][nextJ] != '#') {
                continue;
              }
              int preI = i - direction[0], preJ = j - direction[1];
              if (preI >= 0 && preI < m && preJ >= 0 && preJ < n && board[preI][preJ] != '#') {
                continue;
              }
              return true;
            }
          }
        }
      }
    }
    return false;
  }

}