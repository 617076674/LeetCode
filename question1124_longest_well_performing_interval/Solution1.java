package question1124_longest_well_performing_interval;

public class Solution1 {

  public int longestWPI(int[] hours) {
    int[] sums = new int[hours.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
    }
    int result = 0;
    for (int i = 0; i < hours.length; i++) {
      for (int j = i; j < hours.length; j++) {
        // [i, j]
        if (sums[j + 1] - sums[i] > 0) {
          result = Math.max(result, j - i + 1);
        }
      }
    }
    return result;
  }

}