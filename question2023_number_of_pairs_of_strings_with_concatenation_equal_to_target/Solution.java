package question2023_number_of_pairs_of_strings_with_concatenation_equal_to_target;

public class Solution {

  public int numOfPairs(String[] nums, String target) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (target.equals(nums[i] + nums[j])) {
          result++;
        }
        if (target.equals(nums[j] + nums[i])) {
          result++;
        }
      }
    }
    return result;
  }

}