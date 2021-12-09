package question0805_split_array_with_same_average;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  public boolean splitArraySameAverage(int[] nums) {
    int total = 0;
    for (int num : nums) {
      total += num;
    }
    int mid = nums.length / 2;
    dfs1(nums, 0, mid - 1, 0, 0, 0);
    dfs2(nums, mid, nums.length - 1, mid, 0, 0);
    for (Map.Entry<Integer, Set<Integer>> entry1 : map1.entrySet()) {
      for (Map.Entry<Integer, Set<Integer>> entry2 : map2.entrySet()) {
        if (entry1.getKey() + entry2.getKey() == nums.length || entry1.getKey() + entry2.getKey() == 0) {
          continue;
        }
        Set<Integer> set1 = entry1.getValue(), set2 = entry2.getValue();
        for (int sum1 : set1) {
          if (total * (entry1.getKey() + entry2.getKey()) % nums.length == 0) {
            int sum2 = total * (entry1.getKey() + entry2.getKey()) / nums.length - sum1;
            if (set2.contains(sum2)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  private Map<Integer, Set<Integer>> map1 = new HashMap<>();

  private Map<Integer, Set<Integer>> map2 = new HashMap<>();

  private void dfs1(int[] nums, int left, int right, int index, int count, int sum) {
    if (index == right + 1) {
      Set<Integer> set = map1.get(count);
      if (null == set) {
        set = new HashSet<>();
        set.add(sum);
        map1.put(count, set);
      } else {
        set.add(sum);
      }
      return;
    }
    dfs1(nums, left, right, index + 1, count + 1, sum + nums[index]);
    dfs1(nums, left, right, index + 1, count, sum);
  }

  private void dfs2(int[] nums, int left, int right, int index, int count, int sum) {
    if (index == right + 1) {
      Set<Integer> set = map2.get(count);
      if (null == set) {
        set = new HashSet<>();
        set.add(sum);
        map2.put(count, set);
      } else {
        set.add(sum);
      }
      return;
    }
    dfs2(nums, left, right, index + 1, count + 1, sum + nums[index]);
    dfs2(nums, left, right, index + 1, count, sum);
  }

}