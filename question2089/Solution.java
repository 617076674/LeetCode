package question2089;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public List<Integer> targetIndices(int[] nums, int target) {
    Arrays.sort(nums);
    List<Integer> result = new ArrayList<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        result.add(i);
      }
    }
    return result;
  }

}