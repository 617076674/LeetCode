package question0220_contains_duplicate_iii;

import java.util.TreeMap;

public class Solution1 {

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    int left = 0, right = -1;            //[left, right]为我们的滑动窗口
    TreeMap<Long, Integer> window = new TreeMap<>();
    while (left < nums.length) {
      if (right + 1 < nums.length && right - left < k) {
        right++;
        Long ceil = window.ceilingKey(-(long) t + nums[right]);
        if (null != ceil && ceil <= (long) t + nums[right]) {
          return true;
        }
        window.put((long) nums[right], window.getOrDefault((long) nums[right], 0) + 1);
      } else {
        window.put((long) nums[left], window.get((long) nums[left]) - 1);
        if (window.get((long) nums[left]) == 0) {
          window.remove((long) nums[left]);
        }
        left++;
      }
    }
    return false;
  }

}
