package question0502_ipo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    Integer[] indexes = new Integer[capital.length];
    for (int i = 0; i < indexes.length; i++) {
      indexes[i] = i;
    }
    Arrays.sort(indexes, Comparator.comparingInt(index -> capital[index]));
    int money = w, index = 0;
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
        (index1, index2) -> profits[index2] - profits[index1]);
    while (true) {
      if (index >= indexes.length) {
        break;
      }
      while (index < indexes.length && money >= capital[indexes[index]]) {
        priorityQueue.add(indexes[index]);
        index++;
      }
      if (priorityQueue.isEmpty()) {
        break;
      }
      while (!priorityQueue.isEmpty()) {
        int cur = priorityQueue.poll();
        money += profits[cur];
        while (index < indexes.length && money >= capital[indexes[index]]) {
          priorityQueue.add(indexes[index]);
          index++;
        }
        --k;
        if (k == 0) {
          return money;
        }
      }
    }
    return money;
  }

}