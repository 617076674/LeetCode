package question1986_minimum_number_of_work_sessions_to_finish_the_tasks;

public class Solution {

  private int result;

  public int minSessions(int[] tasks, int sessionTime) {
    result = tasks.length;
    int[] height = new int[tasks.length];
    dfs(tasks, sessionTime, height, 0, 0, 0);
    return result;
  }

  private void dfs(int[] tasks, int sessionTime, int[] height, int taskIndex, int tempResult,
                   int heightIndex) {
    if (tempResult >= result) {
      return;
    }
    if (taskIndex == tasks.length) {
      result = Math.min(result, tempResult);
      return;
    }
    // 第 taskIndex 个任务单独填充
    height[heightIndex] = tasks[taskIndex];
    dfs(tasks, sessionTime, height, taskIndex + 1, tempResult + 1, heightIndex + 1);
    height[heightIndex] = 0;
    // 第 taskIndex 个任务填充至前面 [0, heightIndex - 1] 范围内
    for (int i = 0; i <= heightIndex - 1; i++) {
      if (tasks[taskIndex] + height[i] <= sessionTime) {
        height[i] += tasks[taskIndex];
        dfs(tasks, sessionTime, height, taskIndex + 1, tempResult, heightIndex);
        height[i] -= tasks[taskIndex];
      }
    }
  }

}