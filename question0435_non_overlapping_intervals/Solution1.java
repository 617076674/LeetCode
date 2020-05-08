package question0435_non_overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 首先对区间按左值由小到大进行排序。
 *
 * 动态规划。
 *
 * 状态定义：
 * dp[i]表示考虑第[0, i]个区间，所能保留的最大区间数目。
 *
 * 初始化条件：
 * 当 i == 0 时， dp[0] = 1。
 *
 * 状态转移：
 * （1）我们可以不考虑第i个区间，那么dp[i] = dp[i - 1]。
 * （2）我们也可以考虑第i个区间，那么dp[i] = max(dp[k] + 1, dp[i])，其中k∈[0, i - 1]，且第k个区间与第i个区间不重合
 *
 * 时间复杂度是O(n ^ 2)，其中n为区间个数。空间复杂度是O(n)。
 *
 * 执行用时：244ms，击败5.36%。消耗内存：38.7MB，击败61.47%。
 */
public class Solution1 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n;
        if (null == intervals || (n = intervals.length) == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[n];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];   //不考虑第i个区间
            for (int k = 0; k < i; k++) {   //考虑第i个区间
                if (intervals[k][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[k] + 1, dp[i]);
                }
            }
            result = Math.max(dp[i], result);
        }
        return n - result;
    }
}
