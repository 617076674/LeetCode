package question2160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  private List<Integer> list = new ArrayList<>();

  private int minValue = Integer.MAX_VALUE;

  private int[] nums = new int[4];

  public int minimumSum(int num) {
    while (num > 0) {
      list.add(num % 10);
      num /= 10;
    }
    Arrays.fill(nums, -1);
    dfs(0);
    return minValue;
  }

  private void dfs(int index) {
    if (index == list.size()) {
      minValue = Math.min(nums[0] * 10 + nums[1] + nums[2] * 10 + nums[3], minValue);
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == -1) {
        nums[i] = list.get(index);
        dfs(index + 1);
        nums[i] = -1;
      }
    }
  }

}