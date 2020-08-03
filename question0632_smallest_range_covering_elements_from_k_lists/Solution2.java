package question0632_smallest_range_covering_elements_from_k_lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 参考LeetCode076的思路。
 *
 * 时间复杂度和空间复杂度均是 O(n * k)，其中 n 为列表的平均长度，k 为列表的数量。
 *
 * 执行用时：110ms，击败14.79%。消耗内存：47.8MB，击败11.76%。
 */
public class Solution2 {
  public int[] smallestRange(List<List<Integer>> nums) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.size(); i++) {
      for (int j = 0; j < nums.get(i).size(); j++) {
        if (!map.containsKey(nums.get(i).get(j))) {
          map.put(nums.get(i).get(j), new ArrayList<>());
        }
        map.get(nums.get(i).get(j)).add(i);
        min = Math.min(min, nums.get(i).get(j));
        max = Math.max(max, nums.get(i).get(j));
      }
    }
    int left = min, right = min, need = nums.size(), resultLeft = min, resultRight = max + 1;
    int[] window = new int[need];
    while (right <= max) {
      List<Integer> listRight = map.get(right);
      if (null != listRight) {
        for (int num : listRight) {
          if (window[num] == 0) {
            need--;
          }
          window[num]++;
        }
      }
      right++;
      while (need == 0) {
        if (right - left < resultRight - resultLeft) {
          resultLeft = left;
          resultRight = right;
        }
        List<Integer> listLeft = map.get(left);
        if (null != listLeft) {
          for (int num : listLeft) {
            window[num]--;
            if (window[num] == 0) {
              need++;
            }
          }
        }
        left++;
      }
    }
    return new int[] {resultLeft, resultRight - 1};
  }
}
