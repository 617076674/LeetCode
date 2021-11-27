package question1900;

import java.util.LinkedList;

public class Solution {

  private int[] result = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};

  private int firstPlayer, secondPlayer;

  public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
    this.firstPlayer = firstPlayer - 1;
    this.secondPlayer = secondPlayer - 1;
    LinkedList<Integer> queue = new LinkedList<>();
    queue.add((1 << n) - 1);
    int turn = 1;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        dfs(queue.poll(), turn, 0, 31, queue);
      }
      turn++;
    }

    return result;
  }

  private void dfs(int status, int turn, int left, int right, LinkedList<Integer> queue) {
    while (left < right && ((status & (1 << left)) == 0)) {
      left++;
    }
    while (left < right && ((status & (1 << right)) == 0)) {
      right--;
    }
    if (left >= right) {
      queue.add(status);
      return;
    }
    if ((status & 1 << left) != 0 && (status & 1 << right) != 0) {
      if (left == firstPlayer && right == secondPlayer) {
        result[0] = Math.min(result[0], turn);
        result[1] = Math.max(result[1], turn);
        return;
      }
      // left 和 right 进行比拼，必有一胜
      // 1. left 胜利
      if (left == firstPlayer || left == secondPlayer) {
        // left 必胜
        dfs(status ^ (1 << right), turn, left + 1, right - 1, queue);
      } else if (right == firstPlayer || right == secondPlayer) {
        // right 必胜
        dfs(status ^ (1 << left), turn, left + 1, right - 1, queue);
      } else {
        dfs(status ^ (1 << left), turn, left + 1, right - 1, queue);
        // 2. right 胜利
        dfs(status ^ (1 << right), turn, left + 1, right - 1, queue);
      }
    }
  }

}