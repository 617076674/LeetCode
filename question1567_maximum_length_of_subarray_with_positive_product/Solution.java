package question1567_maximum_length_of_subarray_with_positive_product;

public class Solution {

  public int getMaxLen(int[] nums) {
    Integer old = null, even = -1;
    int countNegative = 0, result = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        old = null;
        even = i;
        countNegative = 0;
      } else {
        if (nums[i] < 0) {
          countNegative++;
        }
        if ((countNegative & 1) == 0) {
          result = Math.max(result, i - even);
        } else {
          if (null == old) {
            old = i;
          } else {
            result = Math.max(result, i - old);
          }
        }
      }
    }
    return result;
  }

}