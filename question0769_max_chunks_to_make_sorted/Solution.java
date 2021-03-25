package question0769_max_chunks_to_make_sorted;

public class Solution {
  public int maxChunksToSorted(int[] arr) {
    int result = 0, max = 0;
    for (int i = 0; i < arr.length; ++i) {
      max = Math.max(max, arr[i]);
      if (max == i) {
        result++;
      }
    }
    return result;
  }
}