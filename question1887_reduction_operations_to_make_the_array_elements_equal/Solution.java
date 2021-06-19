package question1887_reduction_operations_to_make_the_array_elements_equal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  public int reductionOperations(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    List<Integer> list = new ArrayList<>(set);
    Collections.sort(list);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < list.size(); i++) {
      map.put(list.get(i), i);
    }
    int result = 0;
    for (int num : nums) {
      result += map.get(num);
    }
    return result;
  }

}