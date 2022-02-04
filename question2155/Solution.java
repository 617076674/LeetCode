package question2155;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Integer> maxScoreIndices(int[] nums) {
    int[] zeros = new int[nums.length + 1];
    for (int i = 1; i <= nums.length; i++) {
      if (nums[i - 1] == 0) {
        zeros[i] = zeros[i - 1] + 1;
      } else {
        zeros[i] = zeros[i - 1];
      }
    }
    int[] ones = new int[nums.length + 1];
    for (int i = nums.length - 1; i >= 0; i--) {
      ones[i] = ones[i + 1];
      if (nums[i] == 1) {
        ones[i]++;
      }
    }
    int max = Integer.MIN_VALUE;
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i <= nums.length; i++) {
      // [0, i - 1] 范围内 0 的个数 + [i, n - 1] 范围内 1 的个数
      int temp = zeros[i] + ones[i];
      if (temp > max) {
        max = temp;
        result.clear();
        result.add(i);
      } else if (temp == max) {
        result.add(i);
      }
    }
    return result;
  }

}