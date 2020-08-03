package question0632_smallest_range_covering_elements_from_k_lists;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 堆。
 *
 * 时间复杂度是 O(n * k * logk)，其中 n 为列表的平均长度，k 为列表的数量。空间复杂度是 O(k)。
 *
 * 执行用时：86ms，击败20.12%。消耗内存：44.6MB，击败76.47%。
 */
public class Solution1 {
  public int[] smallestRange(List<List<Integer>> nums) {
    int k = nums.size();
    int[] indexes = new int[k];
    PriorityQueue<Integer> pq = new PriorityQueue<>(
        Comparator.comparingInt(index -> nums.get(index).get(indexes[index])));
    int left = 0, right = Integer.MAX_VALUE, range = right - left, max = Integer.MIN_VALUE;
    for (int i = 0; i < k; i++) {
      pq.add(i);
      max = Math.max(max, nums.get(i).get(0));
    }
    while (true) {
      int minIndex = pq.poll(), curRange = max - nums.get(minIndex).get(indexes[minIndex]);
      if (curRange < range) {
        range = curRange;
        left = nums.get(minIndex).get(indexes[minIndex]);
        right = max;
      }
      indexes[minIndex]++;
      if (indexes[minIndex] == nums.get(minIndex).size()) {
        return new int[] {left, right};
      }
      pq.add(minIndex);
      max = Math.max(max, nums.get(minIndex).get(indexes[minIndex]));
    }
  }
}