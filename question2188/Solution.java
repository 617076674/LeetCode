package question2188;

import java.util.Arrays;

public class Solution {

  public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
    int max = 0;
    for (int i = 0; i < tires.length; i++) {
      max = Math.max(max,
          (int) (Math.log((changeTime + tires[i][0]) / tires[i][0]) / Math.log(tires[i][1])) + 1);
    }
    max++;
    long[] cost = new long[numLaps + 1], costMin = new long[numLaps + 1];
    Arrays.fill(costMin, Integer.MAX_VALUE);
    for (int i = 0; i < tires.length; i++) {
      long temp = tires[i][0];
      for (int j = 1; j < numLaps + 1; j++) {
        if (j >= max || temp < 0) {
          cost[j] = costMin[j] = Integer.MAX_VALUE;
          continue;
        }
        cost[j] = cost[j - 1] + temp;
        costMin[j] = Math.min(cost[j], costMin[j]);
        temp *= tires[i][1];
      }
    }
    long[][] dp = new long[numLaps + 1][numLaps + 1];
    long[] min = new long[numLaps + 1];
    Arrays.fill(min, Integer.MAX_VALUE);
    min[0] = 0;
    for (int i = 1; i < dp.length; i++) {
      // 第 i - 1 圈由第 j 个轮子持续 k 场完成
        for (int k = 1; k <= i; k++) {
          // 第 j 个轮子持续 k 场
          dp[i][k] = min[i - k] + costMin[k] + changeTime;
          min[i] = Math.min(min[i], dp[i][k]);
        }
    }
    return (int) (min[numLaps] - changeTime);
  }

}