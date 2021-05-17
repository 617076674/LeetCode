package question1848_minimum_distance_to_the_target_element;

public class Solution {
  public int getMinDistance(int[] nums, int target, int start) {
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (target == nums[i]) {
        result = Math.min(result, Math.abs(start - i));
      }
    }
    return result;
  }
}