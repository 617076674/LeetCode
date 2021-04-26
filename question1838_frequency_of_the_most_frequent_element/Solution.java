package question1838_frequency_of_the_most_frequent_element;

import java.util.Arrays;

public class Solution {

  public int maxFrequency(int[] nums, int k) {
    Arrays.sort(nums);
    int left = 0, right = -1, result = 1, window = 0;
    while (right + 1 < nums.length) {
      right++;
      if (right > left && nums[right] != nums[right - 1]) {
        window += (nums[right] - nums[right - 1]) * (right - left);
      }
      while (window > k) {
        window -= nums[right] - nums[left];
        left++;
      }
      result = Math.max(result, right - left + 1);
    }
    return result;
  }

}