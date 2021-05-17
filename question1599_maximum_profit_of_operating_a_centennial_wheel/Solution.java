package question1599_maximum_profit_of_operating_a_centennial_wheel;

public class Solution {

  public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
    int wait = 0, maxProfit = 0, profit = 0, result = 0, i = 0;
    for (; i < customers.length; i++) {
      int people = customers[i] + wait;
      if (people <= 4) {
        wait = 0;
        profit += people * boardingCost - runningCost;
      } else {
        wait = people - 4;
        profit += 4 * boardingCost - runningCost;
      }
      if (profit > maxProfit) {
        maxProfit = profit;
        result = i;
      }
    }
    while (wait > 0) {
      if (wait > 4) {
        profit += 4 * boardingCost - runningCost;
        wait -= 4;
      } else {
        profit += wait * boardingCost - runningCost;
        wait = 0;
      }
      if (profit > maxProfit) {
        maxProfit = profit;
        result = i;
      }
      i++;
    }
    if (maxProfit <= 0) {
      return -1;
    }
    return result + 1;
  }

}