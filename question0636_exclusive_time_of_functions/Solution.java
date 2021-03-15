package question0636_exclusive_time_of_functions;

import java.util.LinkedList;
import java.util.List;

public class Solution {

  public int[] exclusiveTime(int n, List<String> logs) {
    int[] result = new int[n];
    LinkedList<int[]> stack = new LinkedList<>();
    for (String log : logs) {
      int index = Integer.parseInt(log.substring(0, log.indexOf(":")));
      int time = Integer.parseInt(log.substring(log.lastIndexOf(":") + 1));
      if (log.contains("start")) {
        stack.push(new int[] {index, time});
      } else {
        int[] begin = stack.poll();
        int cost = time - begin[1] + 1;
        result[index] += cost;
        if (!stack.isEmpty()) {
          result[stack.peek()[0]] -= cost;
        }
      }
    }
    return result;
  }

}