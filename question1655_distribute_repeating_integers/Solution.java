package question1655_distribute_repeating_integers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  private List<Integer> list;

  private int[] sums;

  private int[][] memo = new int[51][(1 << 10)];

  public boolean canDistribute(int[] nums, int[] quantity) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    sums = new int[1 << quantity.length];
    for (int status = 0; status < (1 << quantity.length); status++) {
      for (int i = 0; i < quantity.length; i++) {
        if ((status & (1 << i)) != 0) {
          sums[status] += quantity[i];
        }
      }
    }
    list = new ArrayList<>(map.values());
    return canDistribute(list.size() - 1, quantity, (1 << quantity.length) - 1) == 1;
  }

  // list 中 [0, index] 范围内的值能否构成状态 status。
  private int canDistribute(int index, int[] quantity, int status) {
    if (status == 0) {
      return 1;
    }
    if (index < 0) {
      return -1;
    }
    if (memo[index][status] != 0) {
      return memo[index][status];
    }
    memo[index][status] = -1;
    int curStatus = status;
    while (curStatus > 0) {
      if (sums[curStatus] <= list.get(index) && canDistribute(index - 1, quantity, status ^ curStatus) == 1) {
        memo[index][status] = 1;
        return 1;
      }
      curStatus = (curStatus - 1) & status;
    }
    if (canDistribute(index - 1, quantity, status) == 1) {
      memo[index][status] = 1;
    }
    return memo[index][status];
  }

}