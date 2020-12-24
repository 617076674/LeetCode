package question0812_largest_triangle_area;

public class Solution {

  public double largestTriangleArea(int[][] points) {
    double result = 0.0;
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        for (int k = j + 1; k < points.length; k++) {
          result = Math.max(result, calculateArea(calculateDistance(points[i], points[j]),
              calculateDistance(points[i], points[k]), calculateDistance(points[j], points[k])));
        }
      }
    }
    return result;
  }

  private double calculateDistance(int[] point1, int[] point2) {
    return Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
  }

  private double calculateArea(double len1, double len2, double len3) {
    if (len1 + len2 <= len3 || len1 + len3 <= len2 || len2 + len3 <= len1) {
      return -1.0;
    }
    double p = (len1 + len2 + len3) / 2;
    return Math.sqrt(p * (p - len1) * (p - len2) * (p - len3));
  }

}