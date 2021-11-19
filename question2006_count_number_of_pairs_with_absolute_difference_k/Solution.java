package question2006_count_number_of_pairs_with_absolute_difference_k;

public class Solution {

  public int countKDifference(int[] nums, int k) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (Math.abs(nums[i] - nums[j]) == k) {
          result++;
        }
      }
    }
    return result;
  }

}