package question1728;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  private static int[] catOriginPosition;

  private static int[] mouseOriginPosition;

  private static int[] foodPosition;

  private int catJump;

  private int mouseJump;

  private int[][][][][] memo;

  private int rows;

  private int cols;

  private String[] grid;

  public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
    this.catJump = catJump;
    this.mouseJump = mouseJump;
    this.rows = grid.length;
    this.cols = grid[0].length();
    this.grid = grid;
    // memo[catX][catY][mouseX][mouseY][1] == 1 表示现在猫在位置 [catX, catY]，老鼠在位置 [mouseX, mouseY]，当前轮次是老鼠动的轮次，其最终结果是老鼠赢
    // memo[catX][catY][mouseX][mouseY][1] == 2 表示现在猫在位置 [catX, catY]，老鼠在位置 [mouseX, mouseY]，当前轮次是老鼠动的轮次，其最终结果是猫赢
    // memo[catX][catY][mouseX][mouseY][2] == 1 表示现在猫在位置 [catX, catY]，老鼠在位置 [mouseX, mouseY]，当前轮次是猫动的轮次，其最终结果是老鼠赢
    // memo[catX][catY][mouseX][mouseY][2] == 2 表示现在猫在位置 [catX, catY]，老鼠在位置 [mouseX, mouseY]，当前轮次是猫动的轮次，其最终结果是猫赢
    this.memo = new int[rows][cols][rows][cols][3];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        switch (grid[i].charAt(j)) {
          case 'C':
            catOriginPosition = new int[] {i, j};
            break;
          case 'M':
            mouseOriginPosition = new int[] {i, j};
            break;
          case 'F':
            foodPosition = new int[] {i, j};
            break;
          default:
        }
      }
    }
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i].charAt(j) == '#' || (i == foodPosition[0] && j == foodPosition[1])) {
          continue;
        }
        for (int k = 1; k <= 2; k++) {
          // 猫在食品的位置，猫必赢
          memo[foodPosition[0]][foodPosition[1]][i][j][k] = 2;
          queue.add(new int[] {foodPosition[0], foodPosition[1], i, j, k});
          // 老鼠在食品的位置，老鼠必赢
          memo[i][j][foodPosition[0]][foodPosition[1]][k] = 1;
          queue.add(new int[] {i, j, foodPosition[0], foodPosition[1], k});
        }
      }
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i].charAt(j) == '#') {
          continue;
        }
        // 猫和老鼠在同一个位置，猫必赢
        for (int k = 1; k <= 2; k++) {
          memo[i][j][i][j][k] = 2;
          queue.add(new int[] {i, j, i, j, k});
        }
      }
    }
    int step = 0;
    while (!queue.isEmpty()) {
      step++;
      if (step > 2000) {
        return false;
      }
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        int[] status = queue.poll();
        for (int[] previousStatus : findAllPreviousStatus(status)) {
          if (memo[previousStatus[0]][previousStatus[1]][previousStatus[2]][previousStatus[3]][previousStatus[4]] != 0) {
            continue;
          }
          if (memo[status[0]][status[1]][status[2]][status[3]][status[4]] == previousStatus[4]) {
            memo[previousStatus[0]][previousStatus[1]][previousStatus[2]][previousStatus[3]][previousStatus[4]] = previousStatus[4];
            queue.add(previousStatus);
          } else if (allNextStatusWin(previousStatus)){
            memo[previousStatus[0]][previousStatus[1]][previousStatus[2]][previousStatus[3]][previousStatus[4]] = previousStatus[4] == 1 ? 2 : 1;
            queue.add(previousStatus);
          }
        }
      }
    }
    return memo[catOriginPosition[0]][catOriginPosition[1]][mouseOriginPosition[0]][mouseOriginPosition[1]][1] == 1;
  }

  // 当前状态已知的状态是 status1，如果 status1 表示的轮次是猫动且老鼠赢，那么我们一定能够确定 status1 的上一个状态 status0 表示的轮次是老鼠动且老鼠赢。
  //                           如果 status1 表示的轮次是老鼠动且猫赢，那么我们一定能够确定 status1 的上一个状态 status0 表示的轮次是猫动且猫赢。
  //                           如果 status1 表示的轮次是老鼠动且其所有下一个状态 status2 都表示猫动且猫赢，那么 status1 表示的轮次是老鼠动且猫赢。
  //                           如果 status1 表示的轮次是猫动且其所有下一个状态 status2 都表示老鼠动且老鼠赢，那么 status1 表示的轮次是猫动且老鼠赢。
  private List<int[]> findAllPreviousStatus(int[] status) {
    List<int[]> result = new ArrayList<>();
    if (status[4] == 1) {
      // status 表示的是老鼠动，那么其前一个状态表示的是猫动
      for (int[] direction : DIRECTIONS) {
        for (int i = 0; i <= catJump; i++) {
          int nextCatX = status[0] + direction[0] * i, nextCatY = status[1] + direction[1] * i;
          if (nextCatX >= 0 && nextCatX < rows && nextCatY >= 0 && nextCatY < cols && grid[nextCatX].charAt(nextCatY) != '#') {
            result.add(new int[] {nextCatX, nextCatY, status[2], status[3], 2});
          } else {
            break;
          }
        }
      }
    } else if (status[4] == 2) {
      // status 表示的是猫动，那么其前一个状态表示的是老鼠动
      for (int[] direction : DIRECTIONS) {
        for (int i = 0; i <= mouseJump; i++) {
          int nextMouseX = status[2] + direction[0] * i, nextMouseY = status[3] + direction[1] * i;
          if (nextMouseX >= 0 && nextMouseX < rows && nextMouseY >= 0 && nextMouseY < cols && grid[nextMouseX].charAt(nextMouseY) != '#') {
            result.add(new int[] {status[0], status[1], nextMouseX, nextMouseY, 1});
          } else {
            break;
          }
        }
      }
    }
    return result;
  }

  private boolean allNextStatusWin(int[] status) {
    if (status[4] == 1) {
      // status 表示的是老鼠动
      for (int[] direction : DIRECTIONS) {
        for (int i = 0; i <= mouseJump; i++) {
          int nextMouseX = status[2] + direction[0] * i, nextMouseY = status[3] + direction[1] * i;
          if (nextMouseX >= 0 && nextMouseX < rows && nextMouseY >= 0 && nextMouseY < cols && grid[nextMouseX].charAt(nextMouseY) != '#') {
            if (memo[status[0]][status[1]][nextMouseX][nextMouseY][2] != 2) {
              return false;
            }
          } else {
            break;
          }
        }
      }
    } else if (status[4] == 2) {
      // status 表示的是猫动
      for (int[] direction : DIRECTIONS) {
        for (int i = 0; i <= catJump; i++) {
          int nextCatX = status[0] + direction[0] * i, nextCatY = status[1] + direction[1] * i;
          if (nextCatX >= 0 && nextCatX < rows && nextCatY >= 0 && nextCatY < cols && grid[nextCatX].charAt(nextCatY) != '#') {
            if (memo[nextCatX][nextCatY][status[2]][status[3]][1] != 1) {
              return false;
            }
          } else {
            break;
          }
        }
      }
    }
    return true;
  }

}