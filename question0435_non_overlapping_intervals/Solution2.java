package question0435_non_overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 首先对区间按左值由小到大进行排序。
 *
 * 贪心算法。
 *
 * 用pre指针指向前一个刚刚添加到最终结果中的区间，那么考虑下一个区间的时候，共有下述三种情形：
 * （1）
 *       pre       ---------------
 *       current      ------
 *  这种情况，我们显然应该舍弃原pre，而选择current作为新的pre，这样可以容纳更多的区间。
 * （2）
 *       pre       ---------------
 *       current          -----------
 *  这种情况，我们保留原pre，舍弃current，这样可以容纳更多的区间。
 * （3）
 *       pre       ---------------
 *       current                    ------
 *  这种情况，pre和current都可以保留，我们令pre指向current即可。
 *
 * 时间复杂度是O(nlogn)，其中n为区间个数。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败93.10%。消耗内存：39.8MB，击败8.33%。
 */
public class Solution2 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n;
        if (null == intervals || (n = intervals.length) == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int result = 0, pre = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[pre][1] > intervals[i][0]) {
                if (intervals[pre][1] > intervals[i][1]) {
                    pre = i;
                }
                result++;
            } else {
                pre = i;
            }
        }
        return result;
    }
}