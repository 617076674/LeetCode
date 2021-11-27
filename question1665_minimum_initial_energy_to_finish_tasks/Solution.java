package question1665_minimum_initial_energy_to_finish_tasks;

import java.util.Arrays;

public class Solution {

    // task1: (a1, b1)
    // task2: (a2, b2)
    // 如果先做 task1，再做 task2，需要的起始能量满足条件：
    // (1) x >= b1
    // (2) x >= b2 + a1
    // (3) x >= a2 + a1
    // => x 最小为 max(b1, max(a2, b2) + a1) => max(b1, max(a1 + a2, a1 + b2))
    // 如果先做 task2，再做 task1，需要的起始能量满足条件：
    // (1) x >= b2
    // (2) x >= b1 + a2
    // (3) x >= a1 + a2
    // => x 最小为 max(b2, max(a1, b1) + a2) => max(b2, max(a1 + a2, a2 + b1))
    // 下面开始讨论，
    // 情况一：b1 >= a1 + a2, b1 >= a1 + b2，那么先做 task1 时需要的最小能量为 b1，先做 task2 时需要的最小能量为 a2 + b1，我们肯定选择先做 task1。
    // 情况二：a1 + a2 >= b1, a2 >= b2，那么先做 task1 时需要的最小能量为 a1 + a2，先做 task2 时需要的最小能量为 max(a1 + a2, a2 + b1)，继续分类讨论
    //      (1) 如果 a1 >= b1，那么先做 task2 时需要的最小能量为 a1 + a2，此时先做 task1 还是先做 task2 无区别。
    //      (2) 如果 a1 <= b1，那么先做 task2 时需要的最小能量为 a2 + b1，此时我们肯定选择先做 task1。
    // 情况三：a1 + b2 >= b1, b2 >= a2，那么先做 task1 时需要的最小能量为 a1 + b2，先做 task2 时需要的最小能量为 max(b2, max(a1 + a2, a2 + b1))，继续分类讨论
    //      (1) 如果 b2 >= a1 + a2, b2 >= a2 + b1，那么先做 task2 时需要的最小能量为 b2，此时我们肯定选择先做 task2。
    //      (2) 如果 a1 + a2 >= b2, a1 >= b1，那么先做 task2 时需要的最小能量为 a1 + a2，此时我们肯定选择先做 task2。
    //      (3) 如果 a2 + b1 >= b2, b1 >= a1，那么先做 task2 时需要的最小能量为 a2 + b1，继续分类讨论
    //             a. a1 + b2 <= a2 + b1，此时我们肯定选择先做 task1。
    //             b. a1 + b2 >= a2 + b1，此时我们肯定选择先做 task2。
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (task1, task2) -> {
            int a1 = task1[0], b1 = task1[1], a2 = task2[0], b2 = task2[1];
            if (b1 >= a1 + a2 && b1 >= a1 + b2) {
                return -1;
            }
            if (a1 + a2 >= b1 && a2 >= b2) {
                return -1;
            }
            if (b2 >= a1 + a2 && b2 >= a2 + b1) {
                return 1;
            }
            if (a1 + a2 >= b2 && a1 >= b1) {
                return 1;
            }
            if (a1 + b2 <= a2 + b1) {
                return -1;
            }
            return 1;
        });
        int result = 0;
        int cur = 0;
        for (int[] task : tasks) {
            result += Math.max(Math.max(task[1], task[0]) - cur, 0);
            cur = Math.max(task[1], Math.max(cur, task[0]));
            cur -= task[0];
        }
        return result;
    }

}