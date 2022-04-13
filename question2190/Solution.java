package question2190;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int mostFrequent(int[] nums, int key) {
    Map<Integer, Integer> num2Cnt = new HashMap<>();
    for (int i = 0; i <= nums.length - 2; i++) {
      if (nums[i] == key) {
        num2Cnt.put(nums[i + 1], num2Cnt.getOrDefault(nums[i + 1], 0) + 1);
      }
    }
    int maxCnt = -1, result = -1;
    for (Map.Entry<Integer, Integer> entry : num2Cnt.entrySet()) {
      if (entry.getValue() > maxCnt) {
        maxCnt = entry.getValue();
        result = entry.getKey();
      }
    }
    return result;
  }

}