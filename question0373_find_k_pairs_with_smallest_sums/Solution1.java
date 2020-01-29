package question0373_find_k_pairs_with_smallest_sums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 优先队列。
 *
 * 时间复杂度是O(n1 * n2)。空间复杂度是O(k)。
 *
 * 执行用时：68ms，击败34.39%。消耗内存：40.9MB，击败41.99%。
 */
public class Solution1 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, (list1, list2) -> {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < list1.size(); i++) {
                sum1 += list1.get(i);
            }
            for (int i = 0; i < list2.size(); i++) {
                sum2 += list2.get(i);
            }
            return sum2 - sum1;
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                if (queue.size() < k) {
                    queue.add(list);
                } else {
                    if (queue.comparator().compare(list, queue.peek()) > 0) {
                        queue.remove();
                        queue.add(list);
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(0, queue.remove());
        }
        return result;
    }
}