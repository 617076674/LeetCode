package question2070_most_beautiful_item_for_each_query;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  public int[] maximumBeauty(int[][] items, int[] queries) {
    Integer[] queryIndexes = new Integer[queries.length];
    for (int i = 0; i < queryIndexes.length; i++) {
      queryIndexes[i] = i;
    }
    Arrays.sort(queryIndexes, Comparator.comparingInt(index -> queries[index]));
    Arrays.sort(items, Comparator.comparingInt(item -> item[0]));
    int index = 0, maxBeauty = 0;
    int[] result = new int[queries.length];
    for (int i = 0; i < queryIndexes.length; i++) {
      int query = queries[queryIndexes[i]];
      while (index < items.length && items[index][0] <= query) {
        maxBeauty = Math.max(items[index][1], maxBeauty);
        index++;
      }
      result[queryIndexes[i]] = maxBeauty;
    }
    return result;
  }

}