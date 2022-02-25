package question2172;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  private int numSlots;

  private int[] pows;

  private Map<Integer, Integer>[] memo;

  public int maximumANDSum(int[] nums, int numSlots) {
    int status = 0;
    for (int i = 0; i < numSlots; i++) {
      status = status * 10 + 2;
    }
    this.numSlots = numSlots;
    pows = new int[numSlots + 1];
    pows[0] = 1;
    for (int i = 1; i < pows.length; i++) {
      pows[i] = pows[i - 1] * 10;
    }
    memo = new Map[nums.length + 1];
    return maximumANDSum(nums, nums.length - 1, status);
  }

  /**
   * [0, index] 范围内的数字填充进，盒子的填充状态为 status
   */
  private int maximumANDSum(int[] nums, int index, int status) {
    if (index == -1) {
      return 0;
    }
    if (null != memo[index]) {
      Integer result = memo[index].get(status);
      if (null != result) {
        return result;
      }
    }
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < numSlots; i++) {
      // 第 (i + 1) 个槽里可以填多少个数字
      int reserve = status % pows[i + 1] / pows[i];
      if (reserve == 0) {
        continue;
      }
      result = Math.max(result, ((i + 1) & nums[index]) + maximumANDSum(nums, index - 1, status - pows[i]));
    }
    if (null == memo[index]) {
      memo[index] = new HashMap<>();
    }
    memo[index].put(status, result);
    return result;
  }

}