package question1828_queries_on_number_of_points_inside_a_circle;

public class Solution {

  public int[] countPoints(int[][] points, int[][] queries) {
    int[] result = new int[queries.length];
    for (int i = 0; i < result.length; i++) {
      int[] query = queries[i];
      for (int[] point : points) {
        if (calculateDistance2(point[0], point[1], query[0], query[1]) <= query[2] * query[2]) {
          result[i]++;
        }
      }
    }
    return result;
  }

  private static int calculateDistance2(int x1, int y1, int x2, int y2) {
    return (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
  }

}