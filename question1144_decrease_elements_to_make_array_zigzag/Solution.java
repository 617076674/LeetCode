package question1144_decrease_elements_to_make_array_zigzag;

public class Solution {

  public int movesToMakeZigzag(int[] nums) {
      int result1 = 0, result2 = 0;
      for (int i = 0; i < nums.length; i++) {
          int gap = 0;
          if (i - 1 >= 0) {
              gap = Math.max(0, nums[i] - nums[i - 1] + 1);
          }
          if (i + 1 < nums.length) {
              gap = Math.max(gap, Math.max(0, nums[i] - nums[i + 1] + 1));
          }
          if ((i & 1) == 0) {
              result1 += gap;
          } else {
              result2 += gap;
          }
      }
      return Math.min(result1, result2);
  }

}