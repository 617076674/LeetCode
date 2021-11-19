package question1001_grid_illumination;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  private static final int[] dx = {1, 1, 1, 0, 0, 0, -1, -1, -1}, dy = {1, 0, -1, 1, 0, -1, 1, 0, -1};

  public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
    Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>(), map3 = new HashMap<>(),
        map4 = new HashMap<>();
    Set<Long> set = new HashSet<>();
    for (int[] lamp : lamps) {
      if (set.contains((long) n * (long) lamp[0] + (long) lamp[1])) {
        continue;
      }
      map1.put(lamp[0], map1.getOrDefault(lamp[0], 0) + 1);
      map2.put(lamp[1], map2.getOrDefault(lamp[1], 0) + 1);
      map3.put(lamp[0] - lamp[1], map3.getOrDefault(lamp[0] - lamp[1], 0) + 1);
      map4.put(lamp[0] + lamp[1], map4.getOrDefault(lamp[0] + lamp[1], 0) + 1);
      set.add((long) n * (long) lamp[0] + (long) lamp[1]);
    }
    int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int[] cur = queries[i];
      if (map1.getOrDefault(cur[0], 0) > 0
          || map2.getOrDefault(cur[1], 0) > 0
          || map3.getOrDefault(cur[0] - cur[1], 0) > 0
          || map4.getOrDefault(cur[0] + cur[1], 0) > 0) {
        result[i] = 1;
      }
      for (int j = 0; j < 9; j++) {
        int x = dx[j] + cur[0], y = dy[j] + cur[1];
        if (x < 0 || x >= n || y < 0 || y >= n) {
          continue;
        }
        if (set.remove((long) x * (long) n + (long) y)) {
          map1.put(x, map1.get(x) - 1);
          map2.put(y, map2.get(y) - 1);
          map3.put(x - y, map3.get(x - y) - 1);
          map4.put(x + y, map4.get(x + y) - 1);
        }
      }
    }
    return result;
  }

}