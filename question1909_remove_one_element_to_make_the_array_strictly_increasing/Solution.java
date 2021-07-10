package question1909_remove_one_element_to_make_the_array_strictly_increasing;

public class Solution {
  public boolean canBeIncreasing(int[] nums) {
    int index = -1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] <= nums[i - 1]) {
        index = i;
        break;
      }
    }
    return canBeIncreasingHelper(nums, index) || canBeIncreasingHelper(nums, index - 1);
  }

  private static boolean canBeIncreasingHelper(int[] nums, int skip) {
    if (skip == 0) {
      for (int i = 2; i < nums.length; i++) {
        if (nums[i] <= nums[i - 1]) {
          return false;
        }
      }
      return true;
    }
    int pre = 0;
    for (int i = 1; i < nums.length; i++) {
      if (i == skip) {
        continue;
      }
      if (nums[i] <= nums[pre]) {
        return false;
      }
      pre = i;
    }
    return true;
  }
}