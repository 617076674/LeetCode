package question0373_find_k_pairs_with_smallest_sums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution3 {

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> result = new ArrayList<>();
    PriorityQueue<List<Integer>> pq =
        new PriorityQueue<>(Comparator.comparingInt(list -> (nums1[list.get(0)] + nums2[list.get(1)])));
    pq.add(getList(0, 0, 0));
    while (result.size() < k && !pq.isEmpty()) {
      List<Integer> list = pq.poll();
      List<Integer> temp = new ArrayList<>();
      temp.add(nums1[list.get(0)]);
      temp.add(nums2[list.get(1)]);
      result.add(temp);
      if (list.get(1) + 1 < nums2.length) {
        pq.add(getList(list.get(0), list.get(1) + 1, 1));
      }
      if (list.get(2) == 0) {
        if (list.get(0) + 1 < nums1.length) {
          pq.add(getList(list.get(0) + 1, list.get(1), 0));
        }
      }
    }
    return result;
  }

  // flag 是 0，上一次移动的不是 num2，此次可以移动 num1 或 num2；flag 是 1，上一次移动的是 num2，此次只能移动 num2
  private static List<Integer> getList(int num1, int num2, int flag) {
    List<Integer> list = new ArrayList<>();
    list.add(num1);
    list.add(num2);
    list.add(flag);
    return list;
  }

}