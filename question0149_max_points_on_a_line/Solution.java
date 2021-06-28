package question0149_max_points_on_a_line;

public class Solution {

  public int maxPoints(int[][] points) {
    if (points.length <= 2) {
      return points.length;
    }
    int result = 0;
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
        int temp = 0;
        if (x1 == x2) {
          for (int[] point : points) {
            if (point[0] == x1) {
              temp++;
            }
          }
        } else {
          for (int[] point : points) {
            if ((x1 - x2) * point[1] == (y1 - y2) * point[0] + x1 * y2 - x2 * y1) {
              temp++;
            }
          }
        }
        result = Math.max(result, temp);
      }
    }
    return result;
  }

}