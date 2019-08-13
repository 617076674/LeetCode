package question0252;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qianyihui
 * @date 2019-08-13
 *
 * 将会议按开始时间升序排序，再判断一场会议的开始时间和其前一场会议的结束时间是否冲突。
 *
 * 时间复杂度是O(nlogn)，其中n为intervals数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：86ms，击败12.50%。消耗内存：40.7MB，击败100.00%。
 */
public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
