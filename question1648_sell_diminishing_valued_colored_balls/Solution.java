package question1648_sell_diminishing_valued_colored_balls;

import java.util.Arrays;

public class Solution {

  private static final int MOD = 1000000007;

  public int maxProfit(int[] inventory, int orders) {
    Arrays.sort(inventory);
    long sum = 0;
    for (int num : inventory) {
      sum += num;
    }
    long remainAverage = (sum - orders) / inventory.length;
    long remainModule = (sum - orders) % inventory.length;
    long result = 0;
    for (int i = 0; i < inventory.length; i++) {
      if (inventory[i] <= remainAverage) {
        sum -= inventory[i];
        remainAverage = (sum - orders) / (inventory.length - i - 1);
        remainModule = (sum - orders) % (inventory.length - i - 1);
      } else {
        if (remainModule != 0) {
          remainAverage++;
          result += (inventory[i] - remainAverage) * (inventory[i] + remainAverage + 1) / 2;
          result %= MOD;
          sum -= remainAverage;
          remainAverage = (sum - orders) / (inventory.length - i - 1);
          remainModule = (sum - orders) % (inventory.length - i - 1);
        } else {
          sum -= remainAverage;
          result += (inventory[i] - remainAverage) * (inventory[i] + remainAverage + 1) / 2;
          result %= MOD;
        }
      }
    }
    return (int) result % MOD;
  }

}