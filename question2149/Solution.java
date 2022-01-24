package question2149;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public int[] rearrangeArray(int[] nums) {
    List<Integer> positives = new ArrayList<>(nums.length), negatives = new ArrayList<>(nums.length);
    for (int num : nums) {
      if (num > 0) {
        positives.add(num);
      } else {
        negatives.add(num);
      }
    }
    int[] result = new int[nums.length];
    int index1 = 0, index2 = 0;
    for (int i = 0; i < result.length; i++) {
      if (i % 2 == 0) {
        result[i] = positives.get(index1++);
      } else {
        result[i] = negatives.get(index2++);
      }
    }
    return result;
  }

}