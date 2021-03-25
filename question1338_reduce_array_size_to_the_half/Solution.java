package question1338_reduce_array_size_to_the_half;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
  public int minSetSize(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : arr) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Integer> pq =
        new PriorityQueue<>((item1, item2) -> map.get(item2) - map.get(item1));
    for (int num : map.keySet()) {
      pq.add(num);
    }
    int result = 0, sum = 0, half = arr.length / 2;
    while (sum < half) {
      sum += map.get(pq.poll());
      result++;
    }
    return result;
  }
}