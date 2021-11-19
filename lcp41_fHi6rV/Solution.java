package lcp41_fHi6rV;

import java.util.LinkedList;

public class Solution {

  private static final int[] dirX = {1, -1, 0, 0, 1, 1, -1, -1};

  private static final int[] dirY = {0, 0, -1, 1, -1, 1, -1, 1};

  private int m, n;

  public int flipChess(String[] chessboard) {
    m = chessboard.length;
    n = chessboard[0].length();
    char[][] board = copyBoard(chessboard);
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == '.') {
          char[][] copy = copyBoard(chessboard);
          copy[i][j] = 'X';
          res = Math.max(res, process(copy, i, j));
        }
      }
    }
    return res;
  }

  private char[][] copyBoard(String[] chessboard) {
    char[][] board = new char[m][n];
    int idx = 0;
    for (String line : chessboard) {
      board[idx++] = line.toCharArray();
    }
    return board;
  }

  private int process(char[][] arr, int x, int y) {
    LinkedList<Integer> q = new LinkedList<>();
    for (int i = 0; i < 8; i++) {
      int nextX = x + dirX[i], nextY = y + dirY[i];
      q.addAll(search(arr, nextX, nextY, dirX[i], dirY[i]));
    }
    int res = q.size();
    while (!q.isEmpty()) {
      int pos = q.poll();
      res += process(arr, pos / 10, pos % 10);
    }
    return res;
  }

  private LinkedList<Integer> search(char[][] arr, int x, int y, int stepX, int stepY) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    boolean flag = false;
    while (check(x, y)) {
      if (arr[x][y] != 'O') {
        flag = arr[x][y] == 'X';
        break;
      } else {
        linkedList.add(x * 10 + y);
        arr[x][y] = 'X';
      }
      x += stepX;
      y += stepY;
    }
    if (!flag) {
      // 还原现场
      while (!linkedList.isEmpty()) {
        int pos = linkedList.poll();
        arr[pos / 10][pos % 10] = 'O';
      }
    }
    return linkedList;
  }

  private boolean check(int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n;
  }

}