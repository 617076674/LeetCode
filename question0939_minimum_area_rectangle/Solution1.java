package question0939_minimum_area_rectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution1 {

  public int minAreaRect(int[][] points) {
    Map<Integer, List<Integer>> rows = new TreeMap<>();
    for (int[] point : points) {
      rows.computeIfAbsent(point[0], z -> new ArrayList()).add(point[1]);
    }
    int result = Integer.MAX_VALUE;
    Map<Integer, Integer> lastx = new HashMap<>();
    for (int x : rows.keySet()) {
      List<Integer> row = rows.get(x);
      Collections.sort(row);
      for (int i = 0; i < row.size(); ++i) {
        for (int j = i + 1; j < row.size(); ++j) {
          int y1 = row.get(i), y2 = row.get(j);
          int code = 40001 * y1 + y2;
          if (lastx.containsKey(code)) {
            result = Math.min(result, (x - lastx.get(code)) * (y2 - y1));
          }
          lastx.put(code, x);
        }
      }
    }
    return result < Integer.MAX_VALUE ? result : 0;
  }

}