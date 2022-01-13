package question0913_cat_and_mouse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  private int[][] graph;

  private int[][][] visited;

  public int catMouseGame(int[][] graph) {
    this.graph = graph;
    visited = new int[graph.length][graph.length][3];
    int mouse = 1, cat = 2;
    Queue<int[]> queue = new LinkedList<>();
    // 如果猫和老鼠出现在同一个节点，猫赢
    for (int i = 1; i < graph.length; i++) {
      for (int k = 1; k <= 2; k++) {
        queue.add(new int[] {i, i, k});
        visited[i][i][k] = 2;
      }
    }
    // 如果老鼠到达洞中，老鼠赢
    for (int i = 1; i < graph.length; i++) {
      for (int k = 1; k <= 2; k++) {
        queue.add(new int[] {0, i, k});
        visited[0][i][k] = 1;
      }
    }
    // 开始 bfs
    while (!queue.isEmpty()) {
      int[] status = queue.poll();
      for (int[] preStatus : findAllPreviousStatus(status)) {
        if (visited[preStatus[0]][preStatus[1]][preStatus[2]] != 0) {
          continue;
        }
        if (visited[status[0]][status[1]][status[2]] == preStatus[2]) {
          visited[preStatus[0]][preStatus[1]][preStatus[2]] = preStatus[2];
          queue.add(preStatus);
        } else if (allNextStatusWin(preStatus)) {
          visited[preStatus[0]][preStatus[1]][preStatus[2]] = preStatus[2] == 1 ? 2 : 1;
          queue.add(preStatus);
        }
      }
    }
    return visited[1][2][1];
  }

  private boolean allNextStatusWin(int[] status) {
    if (status[2] == 1) {
      // 老鼠动
      for (int next : graph[status[0]]) {
        if (visited[next][status[1]][2] != 2) {
          return false;
        }
      }
    } else {
      // 猫动
      for (int next : graph[status[1]]) {
        if (next == 0) {
          // 猫不能进 0
          continue;
        }
        if (visited[status[0]][next][1] != 1) {
          return false;
        }
      }
    }
    return true;
  }

  private List<int[]> findAllPreviousStatus(int[] status) {
    List<int[]> result = new ArrayList<>();
    if (status[2] == 1) {
      // status 表示老鼠动，其上一个状态表示猫动
      for (int pre : graph[status[1]]) {
        if (pre == 0) {
          // 猫不能进 0
          continue;
        }
        result.add(new int[] {status[0], pre, 2});
      }
    } else {
      // status 表示猫动，其上一个状态表示老鼠动
      for (int pre : graph[status[0]]) {
        result.add(new int[] {pre, status[1], 1});
      }
    }
    return result;
  }

}