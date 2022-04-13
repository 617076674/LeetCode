package question2191;

import java.util.Arrays;

public class Solution {

  public int[] sortJumbled(int[] mapping, int[] nums) {
    int[] mappedNums = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      String origin = Integer.toString(nums[i]);
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < origin.length(); j++) {
        sb.append((char) (mapping[origin.charAt(j) - '0'] + '0'));
      }
      mappedNums[i] = Integer.parseInt(sb.toString());
    }
    Integer[] indexes = new Integer[nums.length];
    for (int i = 0; i < indexes.length; i++) {
      indexes[i] = i;
    }
    Arrays.sort(indexes, (id1, id2) -> {
      if (mappedNums[id1] == mappedNums[id2]) {
        return id1 - id2;
      }
      return mappedNums[id1] - mappedNums[id2];
    });
    int[] result = new int[nums.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = nums[indexes[i]];
    }
    return result;
  }

}