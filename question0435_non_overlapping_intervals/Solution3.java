package question0435_non_overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 计算最多有多少个区间不相交。
 *
 * 算法如下：
 * （1）将区间按结束时间从小到大排序。
 * （2）从区间集合 intervals 中选择一个区间 interval，这个 interval 是在当前所有区间中结束最早的。
 * （3）把所有与 interval 相交的区间从区间集合 intervals 中删除。
 * （4）重复步骤 （2） 和 （3），直到 intervals 为空为止。之前选出的 interval 就是最大不相交子集。
 *
 * 时间复杂度是O(nlogn)，其中n为区间个数。空间复杂度是O(1)。
 *
 * 执行用时：5ms，击败48.37%。消耗内存：39.6MB，击败8.33%。
 */
public class Solution3 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (null == intervals || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int count = 1, end = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                count++;
                end = interval[1];
            }
        }
        return intervals.length - count;
    }
}