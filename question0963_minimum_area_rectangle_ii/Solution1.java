package question0963_minimum_area_rectangle_ii;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {

  public double minAreaFreeRect(int[][] points) {
    int N = points.length;
    Point[] A = new Point[N];
    Set<Point> pointSet = new HashSet<>();
    for (int i = 0; i < N; ++i) {
      A[i] = new Point(points[i][0], points[i][1]);
      pointSet.add(A[i]);
    }
    double result = Double.MAX_VALUE;
    for (int i = 0; i < N; ++i) {
      Point p1 = A[i];
      for (int j = 0; j < N; ++j) {
        if (j != i) {
          Point p2 = A[j];
          for (int k = j + 1; k < N; ++k) {
            if (k != i) {
              Point p3 = A[k];
              Point p4 = new Point(p2.x + p3.x - p1.x, p2.y + p3.y - p1.y);

              if (pointSet.contains(p4)) {
                int dot = ((p2.x - p1.x) * (p3.x - p1.x) +
                    (p2.y - p1.y) * (p3.y - p1.y));
                if (dot == 0) {
                  result = Math.min(result, p1.distance(p2) * p1.distance(p3));
                }
              }
            }
          }
        }
      }
    }
    return result < Double.MAX_VALUE ? result : 0;
  }

}