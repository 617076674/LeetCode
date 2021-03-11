package question1561_maximum_number_of_coins_you_can_get;

import java.util.Arrays;

public class Solution {

  public int maxCoins(int[] piles) {
    Arrays.sort(piles);
    int index = piles.length - 2, result = 0;
    for (int i = 0; i < piles.length / 3; i++) {
      result += piles[index];
      index -= 2;
    }
    return result;
  }

}