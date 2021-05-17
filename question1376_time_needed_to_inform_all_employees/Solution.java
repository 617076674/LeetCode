package question1376_time_needed_to_inform_all_employees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    List<Integer>[] relations = new List[n];
    for (int i = 0; i < manager.length; i++) {
      if (-1 == manager[i]) {
        continue;
      }
      if (null == relations[manager[i]]) {
        relations[manager[i]] = new ArrayList<>();
      }
      relations[manager[i]].add(i);
    }
    int result = 0;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {headID, 0});
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      result = Math.max(result, cur[1]);
      if (null != relations[cur[0]]) {
        for (int i = 0; i < relations[cur[0]].size(); i++) {
          queue.add(new int[] {relations[cur[0]].get(i), cur[1] + informTime[cur[0]]});
        }
      }
    }
    return result;
  }

}