package question0529_minesweeper;

/**
 * 深度优先搜索。
 *
 * 时间复杂度和空间复杂度均是 O(m * n)，其中 m 为 board 的行数，n 为 board 的列数。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：40.5MB，击败10.73%。
 */
public class Solution {
  private int m;

  private int n;

  private int[][] around = {{-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}, {1, 0}, {1, 1}, {1, -1}};

  public char[][] updateBoard(char[][] board, int[] click) {
    m = board.length;
    n = board[0].length;
    switch (board[click[0]][click[1]]) {
      case 'M':
        board[click[0]][click[1]] = 'X';
        return board;
      case 'E':
        dfs(board, click[0], click[1]);
    }
    return board;
  }

  private void dfs(char[][] board, int x, int y) {
    int count = 0;
    for (int[] delta : around) {
      int newX = x + delta[0], newY = y + delta[1];
      if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
        if (board[newX][newY] == 'M') {
          count++;
        }
      }
    }
    if (count > 0) {
      board[x][y] = (char) ('0' + count);
    } else {
      board[x][y] = 'B';
      for (int[] delta : around) {
        int newX = x + delta[0], newY = y + delta[1];
        if (newX >= 0 && newX < m && newY >= 0 && newY < n && board[newX][newY] == 'E') {
          dfs(board, newX, newY);
        }
      }
    }
  }
}