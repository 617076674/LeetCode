package question1685_sum_of_absolute_differences_in_a_sorted_array;

public class Solution {

  public int[] getSumAbsoluteDifferences(int[] nums) {
    int[] sums = new int[nums.length + 1];  // sums[i] = nums[0] + ... + nums[i - 1]
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
    }
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      result[i] += (2 * i - nums.length + 1) * nums[i] + sums[nums.length] - sums[i + 1] - sums[i];
    }
    return result;
  }

}