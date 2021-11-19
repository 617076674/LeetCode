package question1968_array_with_elements_not_equal_to_average_of_neighbors;

import java.util.Arrays;

public class Solution {

  public int[] rearrangeArray(int[] nums) {
    int[] copy = Arrays.copyOf(nums, nums.length);
    Arrays.sort(copy);
    int left = 0, right = copy.length - 1;
    for (int i = 0; i < nums.length; i++) {
      if ((i & 1) != 1) {
        nums[i] = copy[left++];
      } else {
        nums[i] = copy[right--];
      }
    }
    return nums;
  }

}