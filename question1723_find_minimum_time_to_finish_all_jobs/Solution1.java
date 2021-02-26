package question1723_find_minimum_time_to_finish_all_jobs;

import java.util.Arrays;

public class Solution1 {

  private int[] heights;

  private int result = Integer.MAX_VALUE;

  public int minimumTimeRequired(int[] jobs, int k) {
    Arrays.sort(jobs);
    int[] newJobs = new int[jobs.length];
    for (int i = 0; i < jobs.length; i++) {
      newJobs[i] = jobs[jobs.length - 1 - i];
    }
    heights = new int[k];
    for (int i = 0; i < k; i++) {
      heights[i] = newJobs[i];
    }
    dfs(newJobs, k);
    return result;
  }

  private void dfs(int[] jobs, int index) {
    if (index == jobs.length) {
      int maxHeight = heights[0];
      for (int i = 1; i < heights.length; i++) {
        maxHeight = Math.max(maxHeight, heights[i]);
      }
      result = Math.min(result, maxHeight);
      return;
    }
    for (int i = 0; i < heights.length; i++) {
      heights[i] += jobs[index];
      dfs(jobs, index + 1);
      heights[i] -= jobs[index];
    }
  }

}
