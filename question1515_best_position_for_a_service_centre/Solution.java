package question1515_best_position_for_a_service_centre;

import java.util.Random;

public class Solution {

  public double getMinDistSum(int[][] positions) {
    double eps = 1e-7;
    double alpha = 1;
    double decay = 1e-3;

    int n = positions.length;
    // 调整批大小
    int batchSize = n;

    double x = 0.0, y = 0.0;
    for (int[] pos : positions) {
      x += pos[0];
      y += pos[1];
    }
    x /= n;
    y /= n;

    while (true) {
      // 将数据随机打乱
      shuffle(positions);
      double xPrev = x;
      double yPrev = y;

      for (int i = 0; i < n; i += batchSize) {
        int j = Math.min(i + batchSize, n);
        double dx = 0.0, dy = 0.0;
        // 计算导数，注意处理分母为零的情况
        for (int k = i; k < j; ++k) {
          int[] pos = positions[k];
          dx += (x - pos[0]) / (Math.sqrt((x - pos[0]) * (x - pos[0]) + (y - pos[1]) * (y - pos[1])) + eps);
          dy += (y - pos[1]) / (Math.sqrt((x - pos[0]) * (x - pos[0]) + (y - pos[1]) * (y - pos[1])) + eps);
        }
        x -= alpha * dx;
        y -= alpha * dy;

        // 每一轮迭代后，将学习率进行衰减
        alpha *= (1.0 - decay);
      }

      // 判断是否结束迭代
      if (Math.sqrt((x - xPrev) * (x - xPrev) + (y - yPrev) * (y - yPrev)) < eps) {
        break;
      }
    }

    return getDist(x, y, positions);
  }

  public void shuffle(int[][] positions) {
    Random rand = new Random();
    int n = positions.length;
    for (int i = 0; i < n; i++) {
      int x = positions[i][0], y = positions[i][1];
      int randIndex = rand.nextInt(n);
      positions[i][0] = positions[randIndex][0];
      positions[i][1] = positions[randIndex][1];
      positions[randIndex][0] = x;
      positions[randIndex][1] = y;
    }
  }

  // 计算服务中心 (xc, yc) 到客户的欧几里得距离之和
  public double getDist(double xc, double yc, int[][] positions) {
    double ans = 0;
    for (int[] pos : positions) {
      ans += Math.sqrt((pos[0] - xc) * (pos[0] - xc) + (pos[1] - yc) * (pos[1] - yc));
    }
    return ans;
  }

}