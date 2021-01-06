package question1046_last_stone_weight;

import java.util.PriorityQueue;

/**
 * 优先队列。
 *
 * 时间复杂度是O(nlogn)，其中n为stones数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：58ms，击败7.25%。消耗内存：34.3MB，击败100.00%。
 */
public class Solution1 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : stones) {
            pq.add(num);
        }
        while (pq.size() >= 2) {
            int num1 = pq.poll(), num2 = pq.poll();
            if (num1 != num2) {
                pq.add(num1 - num2);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

}
