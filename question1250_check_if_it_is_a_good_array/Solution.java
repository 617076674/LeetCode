package question1250_check_if_it_is_a_good_array;

public class Solution {

  public boolean isGoodArray(int[] nums) {
    int temp = nums[0];
    for (int i = 1; i < nums.length; i++) {
      temp = gcd(temp, nums[i]);
      if (temp == 1) {
        return true;
      }
    }
    return temp == 1;
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

}