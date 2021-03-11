package question1481_least_number_of_unique_integers_after_k_removals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : arr) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    List<Integer> list = new ArrayList<>(map.values());
    Collections.sort(list);
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) > k) {
        return list.size() - i;
      }
      k -= list.get(i);
    }
    return 0;
  }

}