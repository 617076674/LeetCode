package question0768_max_chunks_to_make_sorted_ii;

import java.util.Arrays;

public class Solution {

  public int maxChunksToSorted(int[] arr) {
    int[] copy = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      copy[i] = arr[i];
    }
    Arrays.sort(copy);
    long sum1 = 0, sum2 = 0;
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      sum1 += arr[i];
      sum2 += copy[i];
      if (sum1 == sum2) {
        result++;
      }
    }
    return result;
  }

}