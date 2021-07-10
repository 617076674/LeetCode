package question1920_build_array_from_permutationD;

public class Solution {

  public int[] buildArray(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = nums[nums[i]];
    }
    return result;
  }

}