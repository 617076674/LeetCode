package question1979_find_greatest_common_divisor_of_array;

public class Solution {
  public int findGCD(int[] nums) {
    int max = nums[0], min = nums[0];
    for (int i = 1; i < nums.length; i++) {
      max = Math.max(max, nums[i]);
      min = Math.min(min, nums[i]);
    }
    return gcd(max, min);
  }

  private static int gcd(int a, int b) {
      if (b == 0) {
          return a;
      }
      return gcd(b, a % b);
  }
}