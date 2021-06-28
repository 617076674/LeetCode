package question0773_sliding_puzzle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

  private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  private static final int target = 123450;

  private Set<Integer> visited = new HashSet<>();

  public int slidingPuzzle(int[][] board) {
    int result = 0;
    Queue<int[][]> queue = new LinkedList<>();
    queue.add(board);
    visited.add(getStatus(board));
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        int[][] curBoard = queue.poll();
        int curStatus = getStatus(curBoard);
        if (curStatus == target) {
          return result;
        }
        int[] zero = zeroPosition(curBoard);
        for (int[] direction : directions) {
          int x = zero[0], y = zero[1], nextX = zero[0] + direction[0],
              nextY = zero[1] + direction[1];
          if (nextX >= 0 && nextX < 2 && nextY >= 0 && nextY < 3) {
            int[][] newBoard = new int[2][3];
            for (int j = 0; j < 2; j++) {
              for (int k = 0; k < 3; k++) {
                newBoard[j][k] = curBoard[j][k];
              }
            }
            int temp = newBoard[x][y];
            newBoard[x][y] = newBoard[nextX][nextY];
            newBoard[nextX][nextY] = temp;
            int nextStatus = getStatus(newBoard);
            if (!visited.contains(nextStatus)) {
              queue.add(newBoard);
              visited.add(nextStatus);
            }
          }
        }
      }
      result++;
    }
    return -1;
  }

  private static int[] zeroPosition(int[][] board) {
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == 0) {
          return new int[] {i, j};
        }
      }
    }
    return null;
  }

  private int slidingPuzzleHelper(int[][] board, int x, int y) {
    int curStatus = getStatus(board);
    if (curStatus == target) {
      return 0;
    }
    visited.add(curStatus);
    int result = Integer.MAX_VALUE / 2;
    for (int[] direction : directions) {
      int nextX = x + direction[0], nextY = y + direction[1];
      if (nextX >= 0 && nextX < 2 && nextY >= 0 && nextY < 3) {
        int temp = board[x][y];
        board[x][y] = board[nextX][nextY];
        board[nextX][nextY] = temp;
        int nextStatus = getStatus(board);
        if (!visited.contains(nextStatus)) {

          result = Math.min(slidingPuzzleHelper(board, nextX, nextY) + 1, result);
        }
        temp = board[x][y];
        board[x][y] = board[nextX][nextY];
        board[nextX][nextY] = temp;
      }
    }
    return result;
  }

  private static int getStatus(int[][] board) {
    int status = 0;
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        status = status * 10 + board[i][j];
      }
    }
    return status;
  }

}