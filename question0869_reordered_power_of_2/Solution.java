package question0869_reordered_power_of_2;

import java.util.Arrays;

public class Solution {

  public boolean reorderedPowerOf2(int N) {
    int[] A = count(N);
    for (int i = 0; i < 31; ++i) {
      if (Arrays.equals(A, count(1 << i))) {
        return true;
      }
    }
    return false;
  }

  public int[] count(int N) {
    int[] result = new int[10];
    while (N > 0) {
      result[N % 10]++;
      N /= 10;
    }
    return result;
  }

}