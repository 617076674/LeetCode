package question0963_minimum_area_rectangle_ii;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

  public double minAreaFreeRect(int[][] points) {
    int N = points.length;
    Point[] A = new Point[N];
    for (int i = 0; i < N; i++) {
      A[i] = new Point(points[i][0], points[i][1]);
    }
    Map<Integer, Map<Point, List<Point>>> seen = new HashMap<>();
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        Point center = new Point(A[i].x + A[j].x, A[i].y + A[j].y);
        int distance = (A[i].x - A[j].x) * (A[i].x - A[j].x) + (A[i].y - A[j].y) * (A[i].y - A[j].y);
        if (!seen.containsKey(distance)) {
          seen.put(distance, new HashMap<>());
        }
        if (!seen.get(distance).containsKey(center)) {
          seen.get(distance).put(center, new ArrayList<>());
        }
        seen.get(distance).get(center).add(A[i]);
      }
    }
    double result = Double.MAX_VALUE;
    for (Map<Point, List<Point>> info : seen.values()) {
      for (Point center : info.keySet()) {  // center is twice actual
        List<Point> candidates = info.get(center);
        int clen = candidates.size();
        for (int i = 0; i < clen; ++i) {
          for (int j = i + 1; j < clen; ++j) {
            Point P = candidates.get(i);
            Point Q = candidates.get(j);
            Point Q2 = new Point(center);
            Q2.translate(-Q.x, -Q.y);
            result = Math.min(result, P.distance(Q) * P.distance(Q2));
          }
        }
      }
    }
    return result < Double.MAX_VALUE ? result : 0;
  }

}