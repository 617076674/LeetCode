package question1962_remove_stones_to_minimize_the_total;

import java.util.PriorityQueue;

public class Solution {

  public int minStoneSum(int[] piles, int k) {
    int sum = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>((num1, num2) -> num2 - num1);
    for (int pile : piles) {
      sum += pile;
      pq.add(pile);
    }
    while (k > 0) {
      k--;
      if (pq.isEmpty()) {
        return sum;
      }
      int num = pq.poll();
      sum -= num / 2;
      pq.add(num - num / 2);
    }
    return sum;
  }

}