package question0253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author qianyihui
 * @date 2019-08-13
 *
 * 当我们遇到"会议结束"事件时，意味着一些较早开始的会议已经结束。
 * 我们并不关心到底是哪个会议结束。我们所需要的只是一些会议结束,从而提供一个空房间。
 *
 * 时间复杂度是O(nlogn)，其中n为会议数量。空间复杂度是O(n)。
 *
 * 执行用时：7ms，击败92.93%。消耗内存：40.2MB，击败100.00%。
 */
public class Solution2 {
    public int minMeetingRooms(int[][] intervals) {
        int n;
        if (intervals == null || (n = intervals.length) == 0) {
            return 0;
        }
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int index1 = 0, index2 = 0, result = 0;
        while (index1 < n) {
            if (start[index1] >= end[index2]) { //说明此时可以房间复用
                result--;   //由于后面无论是否有房间复用result均加1，故此处如果有房间复用则需要减1
                index2++;
            }
            result++;   //此处无论是否有房间复用都加1
            index1++;
        }
        return result;
    }
}