package question0996_number_of_squareful_arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  private Set<List<Integer>> set = new HashSet<>();

  private Map<Integer, Integer> num2Count = new HashMap<>();

  private int n;

  public int numSquarefulPerms(int[] nums) {
    n = nums.length;
    for (int num : nums) {
      num2Count.put(num, num2Count.getOrDefault(num, 0) + 1);
    }
    dfs(new ArrayList<>());
    return set.size();
  }

  private void dfs(List<Integer> list) {
    if (list.size() == n) {
      set.add(new ArrayList<>(list));
      return;
    }
    for (Map.Entry<Integer, Integer> entry : num2Count.entrySet()) {
      if (entry.getValue() > 0 && check(list, entry.getKey())) {
        entry.setValue(entry.getValue() - 1);
        list.add(entry.getKey());
        dfs(list);
        list.remove(list.size() - 1);
        entry.setValue(entry.getValue() + 1);
      }
    }
  }

  private static boolean check(List<Integer> list, int num) {
    if (list.isEmpty()) {
      return true;
    }
    int sum = num + list.get(list.size() - 1);
    int sqrtSum = (int) Math.sqrt(sum);
    return sqrtSum * sqrtSum == sum;
  }

}