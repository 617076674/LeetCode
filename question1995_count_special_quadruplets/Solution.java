package question1995_count_special_quadruplets;

public class Solution {

  public int countQuadruplets(int[] nums) {
    int result = 0;
    for (int a = 0; a < nums.length; a++) {
      for (int b = a + 1; b < nums.length; b++) {
        for (int c = b + 1; c < nums.length; c++) {
          for (int d = c + 1; d < nums.length; d++) {
            if (nums[a] + nums[b] + nums[c] == nums[d]) {
              result++;
            }
          }
        }
      }
    }
    return result;
  }

}