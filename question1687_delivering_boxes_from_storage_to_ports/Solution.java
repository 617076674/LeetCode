package question1687_delivering_boxes_from_storage_to_ports;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

  public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
    int[] diff = new int[boxes.length + 1];
    // diff[i] 表示 [0, i - 1] 范围内有多少次目的地的转变
    for (int i = 2; i < diff.length; i++) {
      diff[i] = diff[i - 1];
      if (boxes[i - 2][0] != boxes[i - 1][0]) {
        diff[i]++;
      }
    }
    int[] sum = new int[boxes.length + 1];
    // sum[i] = boxes[0][1] + ... + boxes[i - 1][1]
    for (int i = 1; i < sum.length; i++) {
      sum[i] = sum[i - 1] + boxes[i - 1][1];
    }
    int[] dp = new int[boxes.length + 1];
    Deque<Integer> deque = new LinkedList<>();
    deque.add(boxes.length);
    for (int i = boxes.length - 1; i >= 0; i--) {
      while (!deque.isEmpty() && (deque.peekFirst() - i > maxBoxes || sum[deque.peekFirst()] - sum[i] > maxWeight)) {
        deque.pollFirst();
      }
      dp[i] = 2 - diff[i + 1] + diff[deque.peekFirst()] + dp[deque.peekFirst()];
      if (i > 0) {
        int tmp = diff[i] + dp[i];
        while (!deque.isEmpty() && tmp <= diff[deque.peekLast()] + dp[deque.peekLast()]) {
          deque.pollLast();
        }
        deque.add(i);
      }
    }
    return dp[0];
  }

}