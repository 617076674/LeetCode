package question2162;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private int moveCost;

  private int pushCost;

  private int targetSeconds;

  private List<Integer> nums = new ArrayList<>();

  private long minCost = Long.MAX_VALUE;

  public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
    this.moveCost = moveCost;
    this.pushCost = pushCost;
    this.targetSeconds = targetSeconds;
    dfs(startAt, true, 0);
    return (int) minCost;
  }

  private void dfs(int cur, boolean canMove, long cost) {
    if (nums.size() > 4) {
      return;
    }
    if (check()) {
      minCost = Math.min(minCost, cost);
    }
    nums.add(cur);
    dfs(cur, true, cost + pushCost);
    nums.remove(nums.size() - 1);
    if (canMove) {
      for (int i = 0; i <= 9; i++) {
        if (i == cur) {
          continue;
        }
        dfs(i, false, cost + moveCost);
      }
    }
  }

  private boolean check() {
    int[] array = new int[4];
    int idx = 3;
    for (int i = nums.size() - 1; i >= 0; i--) {
      array[idx--] = nums.get(i);
    }
    int result = (array[0] * 10 + array[1]) * 60 + array[2] * 10 + array[3];
    return result == targetSeconds;
  }

}