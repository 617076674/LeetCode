package lcp45;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private int[][] terrain;

  private int[][] obstacle;

  private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  private int n, m;

  private boolean[][][] visited;

  public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
    this.terrain = terrain;
    this.obstacle = obstacle;
    n = terrain.length;
    m = terrain[0].length;
    visited = new boolean[102][102][102];
    visited[position[0]][position[1]][1] = true;
    List<int[]> list = new ArrayList<>();
    bicycleYardHelper(position[0], position[1], 1);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (visited[i][j][1] && !(i == position[0] && j == position[1])) {
          list.add(new int[] {i, j});
        }
      }
    }
    int[][] result = new int[list.size()][2];
    for (int i = 0; i < result.length; i++) {
      result[i] = list.get(i);
    }
    return result;
  }

  private void bicycleYardHelper(int x, int y, int speed) {
    for (int[] direction : DIRECTIONS) {
      int nextX = x + direction[0], nextY = y + direction[1];
      if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
        continue;
      }
      int nextSpeed = speed + (terrain[x][y] - terrain[nextX][nextY] - obstacle[nextX][nextY]);
      if (nextSpeed > 0 && !visited[nextX][nextY][nextSpeed]) {
        visited[nextX][nextY][nextSpeed] = true;
        bicycleYardHelper(nextX, nextY, nextSpeed);
      }
    }
  }

}