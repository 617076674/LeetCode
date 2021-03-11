package question1779_find_nearest_point_that_has_the_same_x_or_y_coordinate;

public class Solution {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int result = -1, minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x || point[1] == y) {
                int temp = distance(x, y, point[0], point[1]);
                if (temp < minDistance) {
                    result = i;
                    minDistance = temp;
                }
            }
        }
        return result;
    }

    private static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

}