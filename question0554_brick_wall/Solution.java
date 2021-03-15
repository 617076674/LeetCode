package question0554_brick_wall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public int leastBricks(List<List<Integer>> wall) {
    Map<Integer, Integer> map = new HashMap<>();
    for (List<Integer> row : wall) {
      int sum = 0;
      for (int i = 0; i < row.size() - 1; i++) {
        sum += row.get(i);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }
    int result = wall.size();
    for (int key : map.keySet()) {
      result = Math.min(result, wall.size() - map.get(key));
    }
    return result;
  }

}