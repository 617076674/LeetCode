package question1716_calculate_money_in_leetcode_bank;

public class Solution {

  public int totalMoney(int n) {
    int result = 0;
    int[] days = new int[n];
    for (int i = 0; i < n; i++) {
      if (i % 7 == 0) {
        days[i] = (i == 0 ? 0 : days[i - 7]) + 1;
      } else {
        days[i] = days[i - 1] + 1;
      }
      result += days[i];
    }
    return result;
  }

}