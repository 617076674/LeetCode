package question2110;

public class Solution {

  public long getDescentPeriods(int[] prices) {
    for (int i = 0; i < prices.length; i++) {
      prices[i] -= prices.length - i;
    }
    long result = 0;
    for (int i = 0; i < prices.length; i++) {
      int j = i;
      while (j < prices.length && prices[j] == prices[i]) {
        j++;
      }
      // [i, j - 1]
      result += (1L + j - i) * (j * 1L - i) / 2;
      i = j - 1;
    }
    return result;
  }

}