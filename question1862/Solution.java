package question1862;

public class Solution {

  private static final int MOD = 1000000007;

  public int sumOfFlooredPairs(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      max = Math.max(num, max);
    }
    int[] count = new int[max + 1];
    for (int num : nums) {
      count[num]++;
    }
    int[] sums = new int[count.length];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + count[i];
    }
    long result = 0;
    for (int y = 1; y <= max; y++) {
      if (count[y] == 0) {
        continue;
      }
      for (int d = 1; d * y <= max; d++) {
        result += 1L * count[y] * d * (sums[Math.min((d + 1) * y - 1, max)] - sums[d * y - 1]);
        result %= MOD;
      }
    }
    return (int) result;
  }

}