package question1752_check_if_array_is_sorted_and_rotated;

import java.util.Arrays;

public class Solution {

  public boolean check(int[] nums) {
    int[] origin = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      origin[i] = nums[i];
    }
    Arrays.sort(origin);
    for (int begin = 0; begin < nums.length; begin++) {
      int i = 0;
      for (; i < nums.length; i++) {
        if (origin[i] != nums[(begin + i) % nums.length]) {
          break;
        }
      }
      if (i == nums.length) {
        return true;
      }
    }
    return false;
  }

}