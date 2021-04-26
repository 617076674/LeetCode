package question1090_largest_values_from_labels;

import java.util.Arrays;

public class Solution {

  public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
    Integer[] indexes = new Integer[values.length];
    for (int i = 0; i < indexes.length; i++) {
      indexes[i] = i;
    }
    Arrays.sort(indexes, (index1, index2) -> values[index2] - values[index1]);
    int[] labelCount = new int[20001];
    int result = 0;
    for (int i = 0; i < indexes.length && num_wanted > 0; i++) {
      if (labelCount[labels[indexes[i]]] < use_limit) {
        labelCount[labels[indexes[i]]]++;
        result += values[indexes[i]];
        num_wanted--;
      }
    }
    return result;
  }

}