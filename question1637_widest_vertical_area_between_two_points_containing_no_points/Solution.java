package question1637_widest_vertical_area_between_two_points_containing_no_points;

import java.util.TreeSet;

public class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] point : points) {
            set.add(point[0]);
        }
        int pre = -1, result = 0;
        for (int num : set) {
            if (pre != -1) {
                result = Math.max(result, num - pre);
            }
            pre = num;
        }
        return result;
    }
}
