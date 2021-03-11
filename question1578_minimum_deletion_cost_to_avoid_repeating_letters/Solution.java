package question1578_minimum_deletion_cost_to_avoid_repeating_letters;

public class Solution {

  public int minCost(String s, int[] cost) {
      int result = 0;
      for (int i = 0; i < s.length(); ) {
          int j = i + 1;
          int sum = cost[i], max = cost[i];
          while (j < s.length() && s.charAt(j) == s.charAt(i)) {
              sum += cost[j];
              max = Math.max(max, cost[j]);
              j++;
          }
          result += sum - max;
          i = j;
      }
      return result;
  }

}