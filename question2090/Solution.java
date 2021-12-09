package question2090;

import java.util.Arrays;

public class Solution {

  public int[] getAverages(int[] nums, int k) {
    long[] sums = new long[nums.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
    }
    int[] result = new int[nums.length];
    for (int i = 0; i < result.length; i++) {
      // [i - k, i + k]
      if (i - k < 0 || i + k >= result.length) {
        result[i] = -1;
      } else {
        result[i] = (int) ((sums[i + k + 1] - sums[i - k]) / (i + k - i + k + 1));
      }
    }
    return result;
  }

}