package question1235_maximum_profit_in_job_scheduling;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * 记忆化搜索。
 * 
 * 执行用时：25ms，击败54.55%。消耗内存：50.1MB，击败10.71%。
 */
public class Solution {

    private Integer[] indexes;

    private Integer[] memo;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, Comparator.comparingInt(index -> startTime[index]));
        memo = new Integer[n];
        return jobScheduling(startTime, endTime, profit, 0);
    }

    /**
     * 在 [index, n - 1] 中选取任务，当前考虑第 index 个任务，
     */
    private int jobScheduling(int[] startTime, int[] endTime, int[] profit, int index) {
        if (index >= startTime.length) {
            return 0;
        }
        if (null != memo[index]) {
            return memo[index];
        }
        memo[index] = Math.max(
            // 做第 index 个任务
            profit[indexes[index]] + jobScheduling(startTime, endTime, profit, findNextJob(startTime, index, endTime[indexes[index]])),
            // 不做第 index 个任务
            jobScheduling(startTime, endTime, profit, index + 1));
        return memo[index];
    }

    private int findNextJob(int[] startTime, int index, int lastEndTime) {
        if (startTime[indexes[indexes.length - 1]] < lastEndTime) {
            return startTime.length;
        }
        // floor 函数
        int left = index + 1, right = startTime.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (lastEndTime == startTime[indexes[mid]]) {
                right = mid - 1;
            } else if (lastEndTime < startTime[indexes[mid]]) {
                right = mid - 1;
            } else if (lastEndTime > startTime[indexes[mid]]) {
                left = mid + 1;
            }
        }
        return left;
    }

}