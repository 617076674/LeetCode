package question2016_maximum_difference_between_increasing_elements;

public class Solution {

  public int maximumDifference(int[] nums) {
    int result = -1;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] < nums[j]) {
          result = Math.max(result, nums[j] - nums[i]);
        }
      }
    }
    return result;
  }

}