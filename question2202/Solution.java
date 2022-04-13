package question2202;

public class Solution {

  public int maximumTop(int[] nums, int k) {
    if (nums.length == 1) {
      if (k % 2 == 0) {
        return nums[0];
      }
      return -1;
    }
    if (k > nums.length) {
      int result = -1;
      for (int num : nums) {
        result = Math.max(result, num);
      }
      return result;
    }
    int result = -1;
    for (int i = 0; i < k - 1; i++) {
      result = Math.max(result, nums[i]);
    }
    if (k < nums.length) {
      result = Math.max(result, nums[k]);
    }
    return result;
  }

}