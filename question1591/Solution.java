package question1591;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  public boolean isPrintable(int[][] targetGrid) {
    Map<Integer, int[]> color2Edges = new HashMap<>();
    int m = targetGrid.length, n = targetGrid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int[] edges = color2Edges.get(targetGrid[i][j]);
        if (null == edges) {
          edges = new int[] {j, j, i, i}; // 左、右、上、下
          color2Edges.put(targetGrid[i][j], edges);
        } else {
          edges[0] = Math.min(j, edges[0]);
          edges[1] = Math.max(j, edges[1]);
          edges[2] = Math.min(i, edges[2]);
          edges[3] = Math.max(i, edges[3]);
        }
      }
    }
    Set<Integer> determinedSet = new HashSet<>();
    while (determinedSet.size() < color2Edges.size()) {
      boolean flag = false;
      for (Map.Entry<Integer, int[]> entry : color2Edges.entrySet()) {
        int color = entry.getKey();
        if (determinedSet.contains(color)) {
          continue;
        }
        int[] edges = entry.getValue();
        boolean innerFlag = true;
        for (int i = edges[2]; i <= edges[3]; i++) {
          for (int j = edges[0]; j <= edges[1]; j++) {
            if (targetGrid[i][j] != color && targetGrid[i][j] != -1) {
              innerFlag = false;
            }
          }
        }
        if (!innerFlag) {
          continue;
        }
        for (int i = edges[2]; i <= edges[3]; i++) {
          for (int j = edges[0]; j <= edges[1]; j++) {
            targetGrid[i][j] = -1;
          }
        }
        determinedSet.add(color);
        flag = true;
      }
      if (!flag) {
        return false;
      }
    }
    return true;
  }

}