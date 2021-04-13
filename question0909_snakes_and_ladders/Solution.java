package question0909_snakes_and_ladders;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public int snakesAndLadders(int[][] board) {
    int n = board.length;
    Integer[] distance = new Integer[n * n + 1];
    distance[1] = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    while (!queue.isEmpty()) {
      int now = queue.poll();
      if (now == n * n) {
        return distance[now];
      }
      for (int next = now + 1; next <= Math.min(now + 6, n * n); next++) {
        int[] rc = get(next, n);
        int nextFinal = board[rc[0]][rc[1]] == -1 ? next : board[rc[0]][rc[1]];
        if (distance[nextFinal] == null) {
          distance[nextFinal] = distance[now] + 1;
          queue.add(nextFinal);
        }
      }
    }
    return -1;
  }

  public int[] get(int s, int N) {
    int quot = (s - 1) / N;
    int rem = (s - 1) % N;
    int row = N - 1 - quot;
    return new int[] {row, row % 2 != N % 2 ? rem : N - 1 - rem};
  }

}