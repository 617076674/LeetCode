package question0435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qianyihui
 * @date 2019-08-19
 *
 * 首先对区间按左值由小到大进行排序
 *
 * 贪心算法。
 *
 * 状态定义：
 * dp[i]:考虑第[0, i]个区间，所能保留的最大区间数目。
 *
 * 状态转移：
 * 当i == 0时，dp[0] = 1。
 *
 * 当i > 0时，我们可以不考虑第i个区间，那么dp[i] = dp[i - 1]。
 *           我们也可以考虑第i个区间，那么dp[i] = max(dp[k] + 1, dp[i])，其中k∈[0, i - 1]，且第k个区间与第i个区间不重合
 *
 * 时间复杂度是O(nlogn)，其中n为区间个数。空间复杂度是O(1)。
 *
 * 执行用时：79ms，击败20.94%。消耗内存：39.2MB，击败48.17%。
 */
public class Solution2 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n;
        if (null == intervals || (n = intervals.length) == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
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
