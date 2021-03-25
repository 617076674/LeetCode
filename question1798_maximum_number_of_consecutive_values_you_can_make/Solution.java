package question1798_maximum_number_of_consecutive_values_you_can_make;

import java.util.Arrays;

public class Solution {

  public int getMaximumConsecutive(int[] coins) {
    Arrays.sort(coins);
    int result = 1;
    for (int coin : coins) {
      if (coin > result) {
        return result;
      } else if (coin == result) {
        result *= 2;
      } else {
        result += coin;
      }
    }
    return result;
  }

}