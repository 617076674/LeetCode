package question1086_high_five;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 哈希表+优先队列
 *
 * 执行用时：7ms，击败50.00%。消耗内存：40.3MB，击败100.00%。
 */
public class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            if (!map.containsKey(item[0])) {
                map.put(item[0], new PriorityQueue<>());
            }
            map.get(item[0]).add(item[1]);
            if (map.get(item[0]).size() > 5) {
                map.get(item[0]).poll();
            }
        }
        int[][] result = new int[map.size()][2];
        int index = 0;
        for (int id : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(id);
            int sum = 0, pqSize = pq.size();
            for (int i = 0; i < pqSize; i++) {
                sum += pq.poll();
            }
            result[index][0] = id;
            result[index++][1] = sum / 5;
        }
        return result;
    }
}