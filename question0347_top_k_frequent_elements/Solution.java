package question0347_top_k_frequent_elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 优先队列。
 *
 * 时间复杂度是 O(max(n, klogk))，其中 n 是数组 nums 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：21ms，击败21.61%。消耗内存：42.2MB，击败79.39%。
 */
public class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (pq.size() < k) {
        pq.add(entry.getKey());
      } else if (map.get(pq.peek()) < entry.getValue()) {
        pq.poll();
        pq.add(entry.getKey());
      }
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = pq.poll();
    }
    return result;
  }
}