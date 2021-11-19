package question1453_maximum_number_of_darts_inside_of_a_circular_dartboard;

public class Solution {

  private static class Point {
    double x, y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  private static double calculateDistance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
  }

  private static Point calculateCircleCenter(Point p1, Point p2, int r) {
    Point mid = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);  // 计算中点
    double d = calculateDistance(p1.x, p1.y, mid.x, mid.y); // 计算 p1 和 p2 距离的一半
    double h = Math.sqrt(r * r - d * d);
    // 计算垂线单位向量
    Point p1ToP2 = new Point(p2.x - p1.x, p2.y - p1.y);
    Point verticalOfP1ToP2 = new Point(-p1ToP2.y, p1ToP2.x);
    double len = calculateDistance(0, 0, verticalOfP1ToP2.x, verticalOfP1ToP2.y);
    verticalOfP1ToP2.x *= h / len;
    verticalOfP1ToP2.y *= h / len;
    return new Point(verticalOfP1ToP2.x + mid.x, verticalOfP1ToP2.y + mid.y);
  }

  public int numPoints(int[][] points, int r) {
    int result = 1;
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points.length; j++) {
        if (i == j) {
          int temp = 0;
          for (int k = 0; k < points.length; k++) {
            if (calculateDistance(points[i][0], points[i][1], points[k][0], points[k][1]) <= r) {
              temp++;
            }
          }
          result = Math.max(result, temp);
        } else {
          double d = calculateDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
          if (d / 2 > r) {
            continue;
          }
          Point p1 = new Point(points[i][0], points[i][1]), p2 = new Point(points[j][0], points[j][1]);
          Point circleCenter = calculateCircleCenter(p1, p2, r);
          int temp = 0;
          for (int k = 0; k < points.length; k++) {
            if (calculateDistance(circleCenter.x, circleCenter.y, points[k][0], points[k][1]) <= r) {
              temp++;
            }
          }
          result = Math.max(temp, result);
        }
      }
    }
    return result;
  }

}