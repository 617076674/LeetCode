package question2154;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int findFinalValue(int[] nums, int original) {
    int result = original;
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    while (true) {
      if (set.contains(result)) {
        result = result * 2;
      } else {
        return result;
      }
    }
  }

}