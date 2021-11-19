package question1354_construct_target_array_with_multiple_sums;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  public boolean isPossible(int[] target) {
    if(target.length == 1){
      return target[0] == 1;
    }
    Queue<Long> queue = new PriorityQueue<>((o1, o2) -> o2.intValue() - o1.intValue());
    long sum = 0;
    for (int i : target) {
      sum += i;
      queue.add(i * 1L);
    }
    while (true) {
      if (queue.peek() == 1) {
        return true;
      }
      long first = queue.poll(), second = queue.peek(), reduce = sum - first, reduceCnt;
      if (second == 1) {
        reduceCnt = Math.max((first - second) / reduce, 1L); //扣除到不比第二个元素(1)小，最少扣除一次
      } else {
        reduceCnt = (first - second) / reduce + 1; //扣减直至比第二大元素小
      }
      first -= reduceCnt * reduce;
      sum -= reduceCnt * reduce;
      if (first <= 0) {
        return false;
      }
      queue.add(first);
    }
  }

}