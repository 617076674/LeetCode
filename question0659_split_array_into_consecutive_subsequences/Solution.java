package question0659_split_array_into_consecutive_subsequences;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

  public boolean isPossible(int[] nums) {
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    for (int x : nums) {
      if (!map.containsKey(x)) {
        map.put(x, new PriorityQueue<>());
      }
      if (map.containsKey(x - 1)) {
        int prevLength = map.get(x - 1).poll();
        if (map.get(x - 1).isEmpty()) {
          map.remove(x - 1);
        }
        map.get(x).offer(prevLength + 1);
      } else {
        map.get(x).offer(1);
      }
    }
    for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
      if (entry.getValue().peek() < 3) {
        return false;
      }
    }
    return true;
  }

}
