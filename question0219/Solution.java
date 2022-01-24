package question0219;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> window = new HashMap<>();
    int left = 0, right = -1;
    while (right + 1 < nums.length) {
      right++;
      window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);
      if (right - left > k) {
        window.put(nums[left], window.get(nums[left]) - 1);
        left++;
      }
      if (window.get(nums[right]) > 1) {
        return true;
      }
    }
    return false;
  }

}