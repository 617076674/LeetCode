package question1776;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

  public static void main(String[] args) {
    int[][] cars = {{3,4},{5,4},{6,3},{9,1}};
//    int[][] cars = {{1,2},{2,1},{4,3},{7,2}};
    System.out.println(Arrays.toString(new Solution().getCollisionTimes(cars)));
  }

  public double[] getCollisionTimes(int[][] cars) {
    double[] result = new double[cars.length];
    result[cars.length - 1] = -1.0;
    LinkedList<double[]> curve = new LinkedList<>();
    curve.addLast(new double[] {0, cars[cars.length - 1][1]});
    for (int i = cars.length - 2; i >= 0; i--) {
      if (cars[i][1] <= curve.peekLast()[1]) {
        curve.clear();
        curve.addLast(new double[] {0, cars[i][1]});
        result[i] = -1.0;
        continue;
      }
      int deltaS = cars[i + 1][0] - cars[i][0];
      double[] pre = curve.pollFirst();
      double total = 0.0;
      while (!curve.isEmpty()) {
        double[] node = curve.pollFirst();
        double increment = pre[1] * (node[0] - pre[0]);
        if (cars[i][1] * node[0] - total - increment == deltaS) {
          result[i] = node[0];
          curve.addFirst(node);
          curve.addFirst(new double[] {0, cars[i][1]});
          break;
        } else if (cars[i][1] * node[0] - total - increment > deltaS) {
          // 说明在 [pre[0], node[0]] 范围内相撞
          result[i] = (deltaS + total - pre[0] * cars[i][1]) * 1.0 / (cars[i][1] - pre[1]) + pre[0];
          curve.addFirst(node);
          curve.addFirst(new double[] {result[i], pre[1]});
          curve.addFirst(new double[] {0, cars[i][1]});
          break;
        }
        total += increment;
        pre = node;
      }
      if (curve.isEmpty()) {
        result[i] = (deltaS + total - pre[0] * cars[i][1]) * 1.0 / (cars[i][1] - pre[1]) + pre[0];
        curve.addFirst(new double[] {result[i], pre[1]});
        curve.addFirst(new double[] {0, cars[i][1]});
      }
    }
    return result;
  }

}