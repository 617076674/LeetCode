package contest12_27.question2;

import java.util.PriorityQueue;

public class Solution {

  public int eatenApples(int[] apples, int[] days) {
    PriorityQueue<Integer> pq =
        new PriorityQueue<>((index1, index2) -> index1 + days[index1] - index2 - days[index2]);
    int result = 0;
    for (int i = 0; i < apples.length || !pq.isEmpty(); i++) {
      while (!pq.isEmpty()) {
        if (i >= pq.peek() + days[pq.peek()]) {
          pq.poll();
        } else {
          break;
        }
      }
      if (i < apples.length && apples[i] > 0) {
        pq.add(i);
      }
      if (!pq.isEmpty()) {
        if (apples[pq.peek()] > 0) {
          result++;
          apples[pq.peek()]--;
          if (apples[pq.peek()] == 0) {
            pq.poll();
          }
        }
      }
    }
    return result;
  }

}