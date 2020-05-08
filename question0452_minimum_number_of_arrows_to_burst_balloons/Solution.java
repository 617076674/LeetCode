package question0452_minimum_number_of_arrows_to_burst_balloons;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法。
 *
 * 如果最多有 n 个不重叠的区间，那么就至少需要 n 个箭头穿透所有区间。
 *
 * 算法如下：
 * （1）将区间按结束时间从小到大排序。
 * （2）从区间集合 points 中选择一个区间 point，这个 point 是在当前所有区间中结束最早的。
 * （3）把所有与 point 相交的区间从区间集合 points 中删除。
 * （4）重复步骤 （2） 和 （3），直到 points 为空为止。之前选出的 point 就是最大不相交子集。
 *
 * 时间复杂度是O(nlogn)，其中n为points数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：25ms，击败80.31%。消耗内存：46.4MB，击败79.63%。
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (null == points || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));    //按右端点从小到大排序
        int result = 1, end = points[0][1];
        for (int[] point : points) {
            if (point[0] > end) {
                end = point[1];
                result++;
            }
        }
        return result;
    }
}