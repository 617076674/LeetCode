package question0939_minimum_area_rectangle;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

  public int minAreaRect(int[][] points) {
    Set<Integer> pointSet = new HashSet<>();
    for (int[] point : points) {
      pointSet.add(40001 * point[0] + point[1]);
    }
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < points.length; ++i) {
      for (int j = i + 1; j < points.length; ++j) {
        if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
          if (pointSet.contains(40001 * points[i][0] + points[j][1]) && pointSet.contains(40001 * points[j][0] + points[i][1])) {
            result = Math.min(result, Math.abs(points[j][0] - points[i][0]) *
                Math.abs(points[j][1] - points[i][1]));
          }
        }
      }
    }
    return result < Integer.MAX_VALUE ? result : 0;
  }

}