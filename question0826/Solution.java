package question0826;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 先对任务按难度进行排序，对每一个工人，在能完成的任务里，选择利润最大的任务。
 *
 * 时间复杂度是O(nlog(n) + mlog(n))，其中n为任务数量，m为工人数量。空间复杂度是O(n)。
 *
 * 执行用时：125ms，击败43.24%。消耗内存：67.4MB，击败5.26%。
 */
public class Solution {
    private class Task {
        int difficulty;
        int profit;

        Task(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;  //n为任务数量
        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(difficulty[i], profit[i]);
        }
        Arrays.sort(tasks, Comparator.comparingInt(task -> task.difficulty));
        int[] maxProfits = new int[n];
        maxProfits[0] = tasks[0].profit;
        for (int i = 1; i < n; i++) {
            maxProfits[i] = Math.max(maxProfits[i - 1], tasks[i].profit);
        }
        int result = 0;
        for (int i = 0; i < worker.length; i++) {
            int index = ceil(tasks, worker[i]);
            if (index == n) {
                result += maxProfits[n - 1];
            } else {
                if (tasks[index].difficulty != worker[i]) {
                    index--;
                }
                if (index >= 0) {
                    result += maxProfits[index];
                }
            }
        }
        return result;
    }

    private int ceil(Task[] tasks, int ability) {
        int left = 0, right = tasks.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (tasks[mid].difficulty <= ability) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left - 1 >= 0 && tasks[left - 1].difficulty == ability) {
            return left - 1;
        }
        return left;
    }
}
