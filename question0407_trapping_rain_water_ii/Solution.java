package question0407_trapping_rain_water_ii;

import java.util.PriorityQueue;

public class Solution {

  public int trapRainWater(int[][] heightMap) {
    int m;
    if (null == heightMap || (m = heightMap.length) < 3) {
      return 0;
    }
    int n;
    if (null == heightMap[0] || (n = heightMap[0].length) < 3) {
      return 0;
    }
    boolean[] visited = new boolean[m * n];
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((num1, num2) -> {
      int row1 = num1 / n, col1 = num1 % n, row2 = num2 / n, col2 = num2 % n;
      return heightMap[row1][col1] - heightMap[row2][col2];
    });
    // 外圈柱子入堆
    for (int j = 0; j < n; j++) {
      int num = j;
      priorityQueue.add(num);
      visited[num] = true;
    }
    for (int i = 1; i < m; i++) {
      int num = i * n + n - 1;
      priorityQueue.add(num);
      visited[num] = true;
    }
    for (int j = n - 2; j >= 0; j--) {
      int num = (m - 1) * n + j;
      priorityQueue.add(num);
      visited[num] = true;
    }
    for (int i = m - 2; i > 0; i--) {
      int num = i * n;
      priorityQueue.add(num);
      visited[num] = true;
    }
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int result = 0;
    while (!priorityQueue.isEmpty()) {
      int cur = priorityQueue.poll(), row = cur / n, col = cur % n;
      for (int[] direction : directions) {
        int nextRow = row + direction[0], nextCol = col + direction[1], nextNum =
            nextRow * n + nextCol;
        if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !visited[nextNum]) {
          if (heightMap[nextRow][nextCol] < heightMap[row][col]) {
            result += heightMap[row][col] - heightMap[nextRow][nextCol];
            heightMap[nextRow][nextCol] = heightMap[row][col];
          }
          visited[nextNum] = true;
          priorityQueue.add(nextNum);
        }
      }
    }
    return result;
  }

}