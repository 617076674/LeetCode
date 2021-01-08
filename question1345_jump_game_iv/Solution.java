package question1345_jump_game_iv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {

  public int minJumps(int[] arr) {
    Map<Integer, List<Integer>> num2Indexes = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (i > 0 && i < arr.length - 1 && arr[i] == arr[i - 1] && arr[i] == arr[i + 1]) {
        continue;
      }
      List<Integer> indexes = num2Indexes.get(arr[i]);
      if (null == indexes) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(i);
        num2Indexes.put(arr[i], tmp);
      } else {
        indexes.add(i);
      }
    }
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[arr.length];
    visited[0] = true;
    queue.add(0);
    int result = 0;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        int now = queue.poll();
        if (now == arr.length - 1) {
          return result;
        }
        if (now + 1 < arr.length && !visited[now + 1]) {
          visited[now + 1] = true;
          queue.add(now + 1);
        }
        if (now - 1 >= 0 && !visited[now - 1]) {
          visited[now - 1] = true;
          queue.add(now - 1);
        }
        for (int next : num2Indexes.get(arr[now])) {
          if (next != now && !visited[next]) {
            visited[next] = true;
            queue.add(next);
          }
        }
      }
      result++;
    }
    return -1;
  }

}