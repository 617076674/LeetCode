package question1840_maximum_building_height;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  public int maxBuilding(int n, int[][] r) {
    if (r == null || r.length == 0) {
      return n - 1;
    }
    Arrays.sort(r, Comparator.comparingInt(x -> x[0]));
    int len = r.length;
    for (int i = len - 2; i >= 0; i--) {
      r[i][1] = Math.min(r[i][1], Math.min(r[i][0] - 1, r[i + 1][1] + r[i + 1][0] - r[i][0]));
    }
    int result = 0;
    for (int i = 1; i <= len - 1; i++) {
      r[i][1] = Math.min(r[i][1], Math.min(r[i][0] - 1, r[i - 1][1] + r[i][0] - r[i - 1][0]));
      result = Math.max(result, (r[i - 1][1] + r[i][1] + r[i][0] - r[i - 1][0]) >> 1);
    }
    result = Math.max(result, r[len - 1][1] + n - r[len - 1][0]);
    return result;
  }

}