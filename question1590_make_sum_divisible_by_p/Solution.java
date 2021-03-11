package question1590_make_sum_divisible_by_p;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int minSubarray(int[] nums, int p) {
    long sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum < p) {
      return -1;
    }
    long mod = sum % p;
    if (mod == 0) {
      return 0;
    }
    int result = nums.length;
    Map<Long, Integer> map = new HashMap<>();
    map.put(0L, -1);
    long prefix = 0;
    for (int i = 0; i < nums.length; i++) {
      prefix += nums[i];
      long curMod = prefix % p;
      map.put(curMod, i);
      long targetMod = curMod >= mod ? (curMod - mod) : (curMod - mod + p);
      Integer index = map.get(targetMod);
      if (null != index) {
        result = Math.min(result, i - index);
      }
    }
    return result == nums.length ? -1 : result;
  }

}