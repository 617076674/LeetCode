package question1306_jump_game_iii;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public boolean canReach(int[] arr, int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    boolean[] visited = new boolean[arr.length];
    visited[start] = true;
    while (!queue.isEmpty()) {
      int now = queue.poll();
      if (arr[now] == 0) {
        return true;
      }
      if (now + arr[now] < arr.length && !visited[now + arr[now]]) {
        visited[now + arr[now]] = true;
        queue.add(now + arr[now]);
      }
      if (now - arr[now] >= 0 && !visited[now - arr[now]]) {
        visited[now - arr[now]] = true;
        queue.add(now - arr[now]);
      }
    }
    return false;
  }

}