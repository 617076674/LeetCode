package question1263_minimum_moves_to_move_a_box_to_their_target_location;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  private static class StatusNode {

    int personX, personY; // 人物坐标

    int boxX, boxY; // 箱子坐标

    int step;

    public StatusNode(int personX, int personY, int boxX, int boxY, int step) {
      this.personX = personX;
      this.personY = personY;
      this.boxX = boxX;
      this.boxY = boxY;
      this.step = step;
    }

  }

  private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  private int m, n;

  public int minPushBox(char[][] grid) {
    m = grid.length;
    n = grid[0].length;
    // 查找箱子和人物的位置
    int personX = 0, personY = 0, boxX = 0, boxY = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 'S') {
          personX = i;
          personY = j;
        }
        if (grid[i][j] == 'B') {
          boxX = i;
          boxY = j;
        }
      }
    }
    boolean[][][][] visited = new boolean[m][n][m][n];
    Queue<StatusNode> queue =
        new PriorityQueue<>(Comparator.comparingInt(statusNode -> statusNode.step));
    visited[personX][personY][boxX][boxY] = true;
    queue.add(new StatusNode(personX, personY, boxX, boxY, 0));
    while (!queue.isEmpty()) {
      StatusNode statusNode = queue.poll();
      if (grid[statusNode.boxX][statusNode.boxY] == 'T') {
        return statusNode.step;
      }
      for (int[] direction : directions) {
        int nextPersonX = statusNode.personX + direction[0],
            nextPersonY = statusNode.personY + direction[1], nextBoxX = statusNode.boxX,
            nextBoxY = statusNode.boxY, nextStep = statusNode.step;
        //人物的前进位置刚好是箱子的位置，那么箱子的位置也要发生改变
        if (nextPersonX == statusNode.boxX && nextPersonY == statusNode.boxY) {
          nextBoxX += direction[0];
          nextBoxY += direction[1];
          nextStep++;  // 箱子动了，步数 +1
        }
        if (check(nextPersonX, nextPersonY, grid) && check(nextBoxX, nextBoxY, grid)
            && !visited[nextPersonX][nextPersonY][nextBoxX][nextBoxY]) {
          visited[nextPersonX][nextPersonY][nextBoxX][nextBoxY] = true;
          queue.add(new StatusNode(nextPersonX, nextPersonY, nextBoxX, nextBoxY, nextStep));
        }
      }
    }
    return -1;
  }

  private boolean check(int x, int y, char[][] grid) {
    return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != '#';
  }

}