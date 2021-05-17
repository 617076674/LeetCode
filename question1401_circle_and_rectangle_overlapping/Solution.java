package question1401_circle_and_rectangle_overlapping;

public class Solution {

  public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2,
                              int y2) {
    double x0 = (x1 + x2) * 0.5, y0 = (y1 + y2) * 0.5;
    double[] p = {Math.abs(x_center - x0), Math.abs(y_center - y0)};
    double[] q = {x2 - x0, y2 - y0};
    double[] u = {Math.max(p[0] - q[0], 0.0), Math.max(p[1] - q[1], 0.0)};
    return Math.sqrt(u[0] * u[0] + u[1] * u[1]) <= radius;
  }

}