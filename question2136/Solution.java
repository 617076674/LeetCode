package question2136;

import java.util.Arrays;

public class Solution {

  public int earliestFullBloom(int[] plantTime, int[] growTime) {
    Integer[] indexes = new Integer[plantTime.length];
    for (int i = 0; i < indexes.length; i++) {
      indexes[i] = i;
    }
    Arrays.sort(indexes, (index1, index2) -> growTime[index2] - growTime[index1]);
    int result = 0;
    int beginPlantTime = 0;
    for (int i = 0; i < indexes.length; i++) {
      result = Math.max(result, beginPlantTime + plantTime[indexes[i]] + growTime[indexes[i]]);
      beginPlantTime += plantTime[indexes[i]];
    }
    return result;
  }

}