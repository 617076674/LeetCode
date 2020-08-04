package question1518_water_bottles;

/**
 * 时间复杂度和空间复杂度均是 O(log(numBottles))。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.4MB，击败61.89%。
 */
public class Solution {
  public int numWaterBottles(int numBottles, int numExchange) {
    return numWaterBottles(numBottles, 0, numExchange);
  }

  private int numWaterBottles(int numBottles, int numEmpty, int numExchange) {
    int total = numBottles + numEmpty;
    if (total < numExchange) {
      return numBottles;
    }
    return numBottles + numWaterBottles(total / numExchange,
        total % numExchange, numExchange);
  }
}