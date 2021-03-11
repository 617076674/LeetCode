package question1780_check_if_number_is_a_sum_of_powers_of_three;

public class Solution {

  public boolean checkPowersOfThree(int n) {
    if (n == 1) {
      return true;
    }
    int k = (int) (Math.log(n) / Math.log(3));
    int removed = (int) Math.pow(3, k);
    if (removed == n) {
      return true;
    }
    if (removed * 2 <= n) {
      return false;
    }
    return checkPowersOfThree(n - removed);
  }

}