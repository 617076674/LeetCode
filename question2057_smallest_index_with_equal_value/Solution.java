package question2057_smallest_index_with_equal_value;

public class Solution {

  public int smallestEqual(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (i % 10 == nums[i]) {
        return i;
      }
    }
    return -1;
  }

}