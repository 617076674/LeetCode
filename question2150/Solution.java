package question2150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public List<Integer> findLonely(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    List<Integer> result = new ArrayList<>(nums.length);
    for (int num : nums) {
      Integer cnt = map.get(num);
      if (null != cnt && cnt == 1 && !map.containsKey(num - 1) && !map.containsKey(num + 1)) {
        result.add(num);
      }
    }
    return result;
  }

}