package question1833_maximum_ice_cream_bars;

import java.util.Arrays;

public class Solution {

  public int maxIceCream(int[] costs, int coins) {
    Arrays.sort(costs);
    int result = 0;
    for (int i = 0; i < costs.length && coins > 0; i++) {
      if (coins >= costs[i]) {
        coins -= costs[i];
        result++;
      }
    }
    return result;
  }

}