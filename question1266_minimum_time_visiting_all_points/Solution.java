package question1266_minimum_time_visiting_all_points;

/**
 * 找规律。
 *
 * 时间复杂度是O(n)，其中n为数组points的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.74%。消耗内存：39.3MB，击败96.51%。
 */
public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int distanceX = Math.abs(points[i][0] - points[i + 1][0]),
                    distanceY = Math.abs(points[i][1] - points[i + 1][1]);
            result += Math.min(distanceX, distanceY) + Math.abs(distanceX - distanceY);
        }
        return result;
    }
}