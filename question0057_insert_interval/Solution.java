package question0057_insert_interval;

/**
 * 时间复杂度是O(n)，其中n是数组intervals的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败80.91%。消耗内存：41.1MB，击败55.60%。
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, start = -1, end = -1;
        for (int i = 0; i < n; i++) {
            if (newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
                start = i;
            }
            if (newInterval[0] > intervals[i][1]) {
                if (i + 1 == n) {
                    start = n;  //新区间newInterval的起点决定该新区间应插在intervals最后
                } else if (newInterval[0] < intervals[i + 1][0]) {
                    start = i + 1;  //intervals中[0, start)索引范围内的区间需要被包含进结果集中
                }
            }
            if (newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) {
                end = i;
            }
            if (newInterval[1] > intervals[i][1]) {
                if (i + 1 == n) {
                    end = n;
                } else if (newInterval[1] < intervals[i + 1][0]) {
                    end = i;    //intervals中[end, n - 1]索引范围内的区间需要被包含进结果集中
                }
            }
        }
        int[] insertInterval = new int[2];  //将[start, end)中的区间进行合并
        if (start == n || end == -1) {  //新插入区间在intervals数组的最前面或者最后面，此时无需合并区间
            insertInterval[0] = newInterval[0];
            insertInterval[1] = newInterval[1];
        } else {
            if (start == -1) {
                insertInterval[0] = newInterval[0]; //新插入区间在intervals数组的最前面
            } else {
                insertInterval[0] = Math.min(newInterval[0], intervals[start][0]);
            }
            if (end == n) {
                insertInterval[1] = newInterval[1]; //新插入区间在intervals数组的最后面
            } else {
                insertInterval[1] = Math.max(newInterval[1], intervals[end][1]);
            }
        }
        int[][] result = new int[Math.max(start, 0) + 1 + Math.max(n - end - 1, 0)][2];
        int index = 0;
        for (; index < start; index++) {
            result[index] = intervals[index];
        }
        result[index++] = insertInterval;
        for (int i = end + 1; i < n; i++) {
            result[index++] = intervals[i];
        }
        return result;
    }
}