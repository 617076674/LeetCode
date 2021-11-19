package question1467;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  private long same;

  private long total;

  private int halfSum;

  public double getProbability(int[] balls) {
    for (int ball : balls) {
      halfSum += ball;
    }
    halfSum /= 2;
    dfs(balls, 0, new HashSet<>(), new HashSet<>(), 0, 0, 1L);
    return same * 1.0 / total;
  }

  private Integer[][] memo = new Integer[7][7];

  private void dfs(int[] balls, int index, Set<Integer> set1, Set<Integer> set2, int count1, int count2, long count) {
    if (index == balls.length) {
      if (count1 == halfSum) {
        total += count;
        if (set1.size() == set2.size()) {
          same += count;
        }
      }
      return;
    }
    for (int i = 0; i <= balls[index]; i++) {
      // i 个球放入 set1 中，balls[index] - i 个球放入放入 set2 中
      if (i + count1 <= halfSum && balls[index] - i + count2 <= halfSum) {
        Set<Integer> copySet1 = new HashSet<>(set1), copySet2 = new HashSet<>(set2);
        if (i > 0) {
          copySet1.add(index);
        }
        if (balls[index] - i > 0) {
          copySet2.add(index);
        }
        dfs(balls, index + 1, copySet1, copySet2, count1 + i, count2 + balls[index] - i, count * combination(balls[index], i));
      }
    }
  }

  private int combination(int n, int k) {
    if (k == 0 || k == n) {
      return 1;
    }
    if (null != memo[n][k]) {
      return memo[n][k];
    }
    memo[n][k] = combination(n - 1, k) + combination(n - 1, k - 1);
    return memo[n][k];
  }

}