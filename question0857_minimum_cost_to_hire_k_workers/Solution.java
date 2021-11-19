package question0857_minimum_cost_to_hire_k_workers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
    Integer[] indexes = new Integer[quality.length];
    for (int i = 0; i < indexes.length; i++) {
      indexes[i] = i;
    }
    Arrays.sort(indexes,
        (index1, index2) -> wage[index1] * quality[index2] - wage[index2] * quality[index1]);
    Queue<Integer> queue = new PriorityQueue<>((quality1, quality2) -> quality2 - quality1);
    int qualityCount = 0;
    for (int i = 0; i < k - 1; i++) {
      queue.add(quality[indexes[i]]);
      qualityCount += quality[indexes[i]];
    }
    double result = Double.MAX_VALUE;
    for (int i = k - 1; i < quality.length; i++) {
      double salary = wage[indexes[i]] * 1.0 / quality[indexes[i]];
      if (queue.size() == k) {
        qualityCount -= queue.poll();
      }
      queue.add(quality[indexes[i]]);
      qualityCount += quality[indexes[i]];
      result = Math.min(result, qualityCount * salary);
    }
    return result;
  }

}