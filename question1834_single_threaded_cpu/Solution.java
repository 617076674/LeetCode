package question1834_single_threaded_cpu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  public int[] getOrder(int[][] tasks) {
    Integer[] indexes = new Integer[tasks.length];
    for (int i = 0; i < indexes.length; i++) {
      indexes[i] = i;
    }
    Arrays.sort(indexes, Comparator.comparingInt(index -> tasks[index][0]));
    PriorityQueue<Integer> pq = new PriorityQueue<>((index1, index2) -> {
      if (tasks[index1][1] == tasks[index2][1]) {
        return index1 - index2;
      }
      return tasks[index1][1] - tasks[index2][1];
    });
    int[] result = new int[tasks.length];
    int time = 0, index = 0, j = 0;
    for (int i = 0; i < tasks.length; i++) {
      if (pq.isEmpty()) {
        time = Math.max(time, tasks[indexes[index]][0]);
      }
      while (index < tasks.length && tasks[indexes[index]][0] <= time) {
        pq.add(indexes[index++]);
      }
      int toProcess = pq.poll();
      time += tasks[toProcess][1];
      result[j++] = toProcess;
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] tasks = {{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
    System.out.println(Arrays.toString(new Solution().getOrder(tasks)));
  }
}