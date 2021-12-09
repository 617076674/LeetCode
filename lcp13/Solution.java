package lcp13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {

  private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private Map<Integer, Integer> p2Index = new HashMap<>();

  private Map<Integer, int[]> index2P = new HashMap<>();

  private String[] maze;

  private int m, n;

  private int index;

  private int[] begin = new int[2], end = new int[2];

  private Integer[][] distance;

  private static final int INF = Integer.MAX_VALUE / 2;

  public int minimalSteps(String[] maze) {
    this.maze = maze;
    this.m = maze.length;
    this.n = maze[0].length();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (maze[i].charAt(j) == 'S') {
          begin[0] = i;
          begin[1] = j;
        } else if (maze[i].charAt(j) == 'T') {
          end[0] = i;
          end[1] = j;
        } else if (maze[i].charAt(j) == 'M') {
          p2Index.put(i * n + j, index);
          index2P.put(index, new int[] {i, j});
          index++;
        }
      }
    }
    if (index == 0) {
      int result = calculateMinDistanceWithoutO(begin, end);
      return result >= INF ? -1 : result;
    }
    distance = new Integer[index + 2][index + 2];
    // 起点标记为 index，终点标记为 index + 1
    index2P.put(index, begin);
    index2P.put(index + 1, end);
    p2Index.put(begin[0] * n + begin[1], index);
    p2Index.put(end[0] * n + end[1], index + 1);
    for (int i = 0; i < index + 1; i++) {
      for (int j = i + 1; j < index + 1; j++) {
        distance[i][j] = distance[j][i] = calculateMinDistanceWithO(index2P.get(i), index2P.get(j));
      }
    }
    for (int i = 0; i < index + 1; i++) {
      distance[i][index + 1] = distance[index + 1][i] =
          calculateMinDistanceWithoutO(index2P.get(i), end);
    }
    int[][] dp = new int[1 << index][index + 2];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], INF);
    }
    for (int i = 0; i < index; i++) {
      dp[1 << i][i] = distance[index][i];
    }
    for (int status = 0; status < dp.length; status++) {
      for (int p = 0; p < index; p++) {
        if ((status & (1 << p)) == 0) {
          continue;
        }
        if ((status & (status - 1)) == 0) {
          continue;
        }
        for (int i = 0; i < index; i++) {
          if ((status & (1 << i)) != 0 && i != p) {
            // 第 i 个 M 未被触发
            dp[status][p] = Math.min(dp[status][p],
                distance[i][p] + dp[status ^ (1 << p)][i]);
          }
        }
      }
    }
    for (int i = 0; i < index; i++) {
      // 选取一个 M
      dp[(1 << index) - 1][index + 1] =
          Math.min(dp[(1 << index) - 1][index + 1],
              distance[i][index + 1] + dp[(1 << index) - 1][i]);
    }
    return dp[(1 << index) - 1][index + 1] >= INF ? -1 : dp[(1 << index) - 1][index + 1];
  }

  private int calculateMinDistanceWithoutO(int[] begin, int[] end) {
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[m][n];
    visited[begin[0]][begin[1]] = true;
    queue.add(begin);
    int step = 0;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        int[] cur = queue.poll();
        if (cur[0] == end[0] && cur[1] == end[1]) {
          return step;
        }
        for (int[] direction : DIRECTIONS) {
          int nextX = cur[0] + direction[0], nextY = cur[1] + direction[1];
          if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && maze[nextX].charAt(nextY) != '#' && !visited[nextX][nextY]) {
            visited[nextX][nextY] = true;
            queue.add(new int[] {nextX, nextY});
          }
        }
      }
      step++;
    }
    return INF;  // 无法到达
  }

  private int calculateMinDistanceWithO(int[] begin, int[] end) {
    Queue<int[]> queue = new LinkedList<>();
    boolean[][][] visited = new boolean[m][n][2];
    visited[begin[0]][begin[1]][0] = true;
    queue.add(new int[] {begin[0], begin[1], 0});
    int step = 0;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        int[] cur = queue.poll();
        if (cur[0] == end[0] && cur[1] == end[1] && cur[2] == 1) {
          return step;
        }
        for (int[] direction : DIRECTIONS) {
          int nextX = cur[0] + direction[0], nextY = cur[1] + direction[1];
          if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && maze[nextX].charAt(nextY) != '#') {
            if (maze[nextX].charAt(nextY) == 'O') {
              if (!visited[nextX][nextY][1]) {
                visited[nextX][nextY][1] = true;
                queue.add(new int[] {nextX, nextY, 1});
              }
            } else {
              if (!visited[nextX][nextY][cur[2]]) {
                visited[nextX][nextY][cur[2]] = true;
                queue.add(new int[] {nextX, nextY, cur[2]});
              }
            }
          }
        }
      }
      step++;
    }
    return INF;
  }

}