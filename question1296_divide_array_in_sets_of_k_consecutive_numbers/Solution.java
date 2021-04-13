package question1296_divide_array_in_sets_of_k_consecutive_numbers;

import java.util.TreeMap;

public class Solution {

  public boolean isPossibleDivide(int[] nums, int k) {
    TreeMap<Integer, Integer> map = new TreeMap();
    for (int card : nums) {
      map.put(card, map.getOrDefault(card, 0) + 1);
    }
    while (!map.isEmpty()) {
      int first = map.firstKey();
      for (int card = first; card < first + k; ++card) {
        if (!map.containsKey(card)) {
          return false;
        }
        int c = map.get(card);
        if (c == 1) {
          map.remove(card);
        } else {
          map.put(card, c - 1);
        }
      }
    }
    return true;
  }

}