package question2144;

import java.util.Arrays;

public class Solution {

  public int minimumCost(int[] cost) {
    Arrays.sort(cost);
    int result = 0;
    for (int i = cost.length - 1; i >= 0; i--) {
      result += cost[i];
      if (i - 1 >= 0) {
        result += cost[i - 1];
        i--;
      }
      i--;
    }
    return result;
  }

}