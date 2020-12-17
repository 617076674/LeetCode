package question0973_k_closest_points_to_origin;

import java.util.PriorityQueue;

/**
 * 优先队列。
 *
 * 时间复杂度是 O(nlogK)，其中 n 为 points 数组的长度。空间复杂度是 O(K)。
 *
 * 执行用时：36ms，击败41.13%。消耗内存：46.7MB，击败91.09%。
 */
public class Solution1 {

  public int[][] kClosest(int[][] points, int K) {
    PriorityQueue<int[]> priorityQueue =
        new PriorityQueue<>((point1, point2) -> point2[0] * point2[0] + point2[1] * point2[1] - point1[0] * point1[0] - point1[1] * point1[1]);
    for (int[] point : points) {
      priorityQueue.add(point);
      if (priorityQueue.size() > K) {
        priorityQueue.poll();
      }
    }
    int[][] result = new int[K][2];
    int index = 0;
    while (!priorityQueue.isEmpty()) {
      result[index++] = priorityQueue.poll();
    }
    return result;
  }

}