package question0452_minimum_number_of_arrows_to_burst_balloons;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法。
 *
 * 时间复杂度是O(nlogn)，其中n为points数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：25ms，击败80.31%。消耗内存：46.4MB，击败79.63%。
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));    //按右端点从小到大排序
        int result = 0;
        long last = Long.MIN_VALUE; //记录上一箭射出的位置
        for (int[] point : points) {
            if (point[0] > last) {
                last = point[1];
                result++;
            }
        }
        return result;
    }
}