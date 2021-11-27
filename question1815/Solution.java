package question1815;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  private Map<Integer, Integer> memo = new HashMap<>();

  public int maxHappyGroups(int batchSize, int[] groups) {
    int[] map = new int[batchSize];
    for (int group : groups) {
      map[group % batchSize]++;
    }
    return maxHappyGroupsHelper(map, batchSize, 0);
  }

  private int maxHappyGroupsHelper(int[] map, int batchSize, int preSum) {
    int key = map2Int(map);
    Integer result = memo.get(key);
    if (null != result) {
      return result;
    }
    result = 0;
    for (int i = 0; i < map.length; i++) {
      if (map[i] > 0) {
        map[i]--;
        if (preSum == 0) {
          result = Math.max(result, 1 + maxHappyGroupsHelper(map, batchSize, (preSum + i) % batchSize));
        } else {
          result = Math.max(result, maxHappyGroupsHelper(map, batchSize, (preSum + i) % batchSize));
        }
        map[i]++;
      }
    }
    memo.put(key, result);
    return result;
  }

  private static int map2Int(int[] map) {
    int result = 0;
    for (int i = map.length - 1; i >= 0; i--) {
      result = result * 10 + map[i];
    }
    return result;
  }

}