package question0253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author qianyihui
 * @date 2019-08-13
 *
 * 时间复杂度是O(nlogn)，其中n为会议数量。空间复杂度是O(n)。
 *
 * 执行用时：93ms，击败21.21%。消耗内存：40.4MB，击败100.00%。
 */
public class Solution1 {
    public int minMeetingRooms(int[][] intervals) {
        int n;
        if (intervals == null || (n = intervals.length) == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0])); //按照会议开始时间进行排序
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();   //最小堆，记录当前正在进行的会议的最早结束时间
        priorityQueue.add(intervals[0][1]); //考虑第0场会议
        for (int i = 1; i < n; i++) {   //考虑第[1, n - 1]场会议
            if (intervals[i][0] >= priorityQueue.peek()) {  //如果第i场会议的开始时间大于等于当前正在进行会议的最早结束时间
                priorityQueue.poll();   //将最早结束的那场会议的结束时间弹出最小堆，因为这个会议的房间被第i场会议占了
            }
            // 这里有两种情况：
            // 1.第i场会议占用了原最小堆顶的那场会议的房间，由于原最小堆顶已经弹出，故第i场会议的结束时间需要入最小堆
            // 2.第i场会议新开一个房间，显然此时也要将第i场会议的结束时间入最小堆
            priorityQueue.add(intervals[i][1]);
        }
        return priorityQueue.size();
    }
}
