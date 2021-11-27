package question2071_maximum_number_of_tasks_you_can_assign;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

  public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
    Arrays.sort(tasks);
    Arrays.sort(workers);
    int left = 1, right = tasks.length;
    while (left < right) {
      if (left + 1 == right) {
        if (check(right, tasks, workers, pills, strength)) {
          return right;
        }
        return left;
      }
      int mid = left + ((right - left) >> 1);
      if (check(mid, tasks, workers, pills, strength)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  private static boolean check(int taskCount, int[] tasks, int[] workers, int pills, int strength) {
    // [0, taskCount - 1] 范围内的 task 能否被完成
    if (taskCount > workers.length) {
      return false;
    }
    TreeMap<Integer, Integer> taskCost2Count = new TreeMap<>();
    for (int i = 0; i < taskCount; i++) {
      taskCost2Count.put(tasks[i], taskCost2Count.getOrDefault(tasks[i], 0) + 1);
    }
    for (int i = workers.length - taskCount; i < workers.length; i++) {
      Map.Entry<Integer, Integer> entry = taskCost2Count.floorEntry(workers[i]);
      if (null == entry) {
        if (pills == 0) {
          return false;
        }
        entry = taskCost2Count.floorEntry(workers[i] + strength);
        if (null == entry) {
          return false;
        }
        pills--;
      }
      if (entry.getValue() == 1) {
        taskCost2Count.remove(entry.getKey());
      } else {
        taskCost2Count.put(entry.getKey(), entry.getValue() - 1);
      }
    }
    return true;
  }

}